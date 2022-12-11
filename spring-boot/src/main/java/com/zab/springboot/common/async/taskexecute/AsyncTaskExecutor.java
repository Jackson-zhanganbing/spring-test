package com.zab.springboot.common.async.taskexecute;

import cn.hutool.core.thread.ThreadUtil;
import cn.hutool.core.util.ReflectUtil;
import com.zab.springboot.common.async.RealTask;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Objects;
import java.util.concurrent.*;

/**
 * 写点注释吧
 *
 * @author zab
 * @date 2022/12/11 0:39
 */
public class AsyncTaskExecutor implements Runnable{

    public static final String THREAD_NAME = "async_task";
    private static final int CORE_POOL_SIZE = 10;
    private static final int MAX_POOL_SIZE = 18;
    private static final int KEEP_ALIVE_TIME = 60;

    private static AsyncTaskExecutor instance;

    private ThreadPoolExecutor threadPoolExecutor;

    private static BlockingQueue<RealTask> taskQueue = new ArrayBlockingQueue<>(500);
    private AsyncTaskExecutor(){

    }

    /**
     * 添加一个任务
     *
     * @author zab
     * @date 2022/12/11 1:13
     */
    public boolean addTask(RealTask task){
        if (taskQueue.contains(task)) {
            return false;
        }
        return taskQueue.add(task);
    }

    public static AsyncTaskExecutor getInstance(){
        if(Objects.isNull(instance)){
            synchronized (AsyncTaskExecutor.class){
                if(Objects.isNull(instance)){
                    instance = ReflectUtil.newInstance(AsyncTaskExecutor.class);
                }
            }
        }

        return instance;
    }


    @Override
    public void run() {
        for (;;){
            ThreadUtil.sleep(1000);
            doTaskExecute();
        }
    }

    private void doTaskExecute() {
        //1、检查线程池是否还有空闲线程可以执行任务
        ThreadPoolExecutor threadPool = getThreadPool();
        int activeCount = threadPool.getActiveCount();
        if(activeCount >= MAX_POOL_SIZE){
            return;
        }
        //2、检查任务队列是否有任务待执行
        if (taskQueue.isEmpty()) {
            return;
        }

        //3、遍历可用线程池线程数，取出线程执行
        for (int i = 0, available = MAX_POOL_SIZE - activeCount; i < available; i++) {
            RealTask task = taskQueue.poll();
            if(Objects.isNull(task)){
                continue;
            }

            threadPool.execute(new Runnable() {
                @Override
                public void run() {
                    Method method = task.getMethod();
                    try {
                        method.invoke(task.getObject(), task.getTaskNo());
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    } catch (InvocationTargetException e) {
                        e.printStackTrace();
                    }
                }
            });
        }

    }


    private ThreadPoolExecutor getThreadPool() {
        if(threadPoolExecutor == null){
            synchronized (this){
                if(threadPoolExecutor == null){
                    threadPoolExecutor = new ThreadPoolExecutor(
                            CORE_POOL_SIZE,
                            MAX_POOL_SIZE,
                            KEEP_ALIVE_TIME,
                            TimeUnit.SECONDS,
                            new ArrayBlockingQueue<>(10),
                            new AsyncTaskThreadFactory(THREAD_NAME),
                            new ThreadPoolExecutor.AbortPolicy()
                    );
                }
            }
        }

        return threadPoolExecutor;
    }

    static class AsyncTaskThreadFactory implements ThreadFactory {

        private String threadName;

        public AsyncTaskThreadFactory(String threadName) {
            this.threadName = threadName;
        }

        @Override
        public Thread newThread(Runnable r) {
            Thread t = new Thread(r);
            t.setName(threadName+t.getName());
            return t;
        }
    }

}
