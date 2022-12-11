package com.zab.springboot.common.async.taskregister;

import cn.hutool.core.util.RandomUtil;
import cn.hutool.core.util.StrUtil;
import com.zab.springboot.common.async.AsyncTaskContext;
import com.zab.springboot.common.async.AsyncTaskException;
import com.zab.springboot.common.async.RealTask;
import com.zab.springboot.common.async.entity.AsyncTask;
import com.zab.springboot.common.async.service.IAsyncTaskService;
import com.zab.springboot.common.async.taskdiscovery.ListableAsyncTaskRepository;
import com.zab.springboot.common.async.taskexecute.AsyncTaskExecutor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 异步任务注册器
 *
 * @author zab
 * @date 2022/12/11 1:17
 */
@Component
public class AsyncTaskRegister {

    @Autowired
    private IAsyncTaskService asyncTaskService;

    @Autowired
    private ListableAsyncTaskRepository listableAsyncTaskRepository;

    /**
     * 注册异步任务：
     * 1、添加数据库
     * 2、放到异步任务执行器的执行队列中
     *
     * @author zab
     * @date 2022/12/11 1:19
     */
    public String registerTask(AsyncTaskContext asyncTaskContext){
        //1、校验参数
        checkParam(asyncTaskContext);

        //3、添加任务队列
        addTaskToQueue(asyncTaskContext);

        //2、保存任务
        return saveTask(asyncTaskContext);
    }

    private void addTaskToQueue(AsyncTaskContext asyncTaskContext) {
        String taskCode = asyncTaskContext.getTaskCode();
        RealTask task = listableAsyncTaskRepository.getTask(taskCode);
        //注册任务的时候，给任务赋值一个唯一编号
        String taskNo = RandomUtil.randomString(64);
        task.setTaskNo(taskNo);

        AsyncTask asyncTask = asyncTaskContext.getAsyncTask();
        asyncTask.setTaskNo(taskNo);
        asyncTaskContext.setAsyncTask(asyncTask);

        AsyncTaskExecutor.getInstance().addTask(task);
    }

    private String saveTask(AsyncTaskContext asyncTaskContext) {
        AsyncTask asyncTask = asyncTaskContext.getAsyncTask();
        asyncTaskService.save(asyncTask);
        return asyncTask.getTaskNo();
    }

    private void checkParam(AsyncTaskContext asyncTaskContext) {
        AsyncTask asyncTask = asyncTaskContext.getAsyncTask();
        String taskCode = asyncTask.getTaskCode();
        if(StrUtil.isBlank(taskCode)){
            throw new AsyncTaskException("taskCode is blank!");
        }
    }
}
