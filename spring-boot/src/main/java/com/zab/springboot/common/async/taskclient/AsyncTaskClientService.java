package com.zab.springboot.common.async.taskclient;

import com.zab.springboot.common.async.AsyncTaskContext;
import com.zab.springboot.common.async.RealTask;
import com.zab.springboot.common.async.entity.AsyncTask;
import com.zab.springboot.common.async.taskregister.AsyncTaskRegister;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 异步任务客户端
 *
 * @author zab
 * @date 2022/12/11 2:14
 */
@Service
public class AsyncTaskClientService {

    @Autowired
    private AsyncTaskRegister asyncTaskRegister;

    public void addAsyncTask(String taskCode){
        AsyncTaskContext asyncTaskContext = new AsyncTaskContext();
        asyncTaskContext.setTaskCode(taskCode);
        AsyncTask asyncTask = new AsyncTask();
        asyncTask.setTaskCode(taskCode).setTaskName("test").setFileName("fileName").setFileUrl("https");
        asyncTaskContext.setAsyncTask(asyncTask);
        asyncTaskRegister.registerTask(asyncTaskContext);
    }
}
