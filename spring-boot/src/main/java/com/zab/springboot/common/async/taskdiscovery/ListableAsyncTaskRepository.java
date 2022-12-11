package com.zab.springboot.common.async.taskdiscovery;

import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONUtil;
import com.zab.springboot.common.async.AsyncTaskException;
import com.zab.springboot.common.async.AsyncTaskMethod;
import com.zab.springboot.common.async.RealTask;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.SmartInitializingSingleton;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.lang.reflect.Method;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 异步任务发现
 *
 * @author zab
 * @date 2022/12/10 21:10
 */
@Slf4j
@Component
public class ListableAsyncTaskRepository implements ApplicationContextAware , SmartInitializingSingleton {

    private ApplicationContext applicationContext;

    private Map<String, RealTask> asyncTaskMap = new ConcurrentHashMap<>(256);

    @Override
    public void afterSingletonsInstantiated() {
        //这里需要写个方法，等所有bean加载完成后，把相关注解标记的方法，保存到这里
        initAsyncTaskToRepository();
    }

    public RealTask getTask(String taskCode){
        return asyncTaskMap.get(taskCode);
    }

    private void initAsyncTaskToRepository() {
        String[] beanNamesForType = applicationContext.getBeanNamesForAnnotation(Service.class);
        log.info("初始化项目中的异步任务类：{}", JSONUtil.toJsonPrettyStr(beanNamesForType));
        for (String beanName : beanNamesForType) {
            Object bean = applicationContext.getBean(beanName);
            Method[] declaredMethods = bean.getClass().getDeclaredMethods();
            for (Method declaredMethod : declaredMethods) {
                if (declaredMethod.isAnnotationPresent(AsyncTaskMethod.class)) {
                    AsyncTaskMethod annotation = declaredMethod.getAnnotation(AsyncTaskMethod.class);
                    String taskCode = annotation.taskCode();
                    checkAsyncTaskCode(taskCode);

                    RealTask realTask = new RealTask();
                    realTask.setMethod(declaredMethod);
                    realTask.setObject(bean);
                    realTask.setTaskCode(taskCode);

                    asyncTaskMap.put(taskCode, realTask);
                }

            }
        }
        log.info("看看异步任务有哪些：{}", JSONUtil.toJsonPrettyStr(asyncTaskMap));
    }

    /**
     * 校验一下taskCode
     *
     * @author zab
     * @date 2022/12/10 22:52
     */
    private void checkAsyncTaskCode(String taskCode) {
        if(StrUtil.isBlank(taskCode)){
            throw new AsyncTaskException("async task define blank code！");
        }
        //异步任务code不能重复
        Set<String> taskCodeSet = asyncTaskMap.keySet();
        if(taskCodeSet.contains(taskCode)){
            throw new AsyncTaskException("async task code has been defined！");
        }
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

}
