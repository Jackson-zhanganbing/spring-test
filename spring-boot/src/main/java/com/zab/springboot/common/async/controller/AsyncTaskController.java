package com.zab.springboot.common.async.controller;


import com.zab.springboot.common.ResponseVo;
import com.zab.springboot.common.async.service.IAsyncTaskService;
import com.zab.springboot.common.async.taskclient.AsyncTaskClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 异步任务表 前端控制器
 * </p>
 *
 * @author zab
 * @since 2022-12-11
 */
@RestController
@RequestMapping("/asyncTask")
public class AsyncTaskController {

    @Autowired
    private IAsyncTaskService asyncTaskService;

    @Autowired
    private AsyncTaskClientService asyncTaskClientService;

    @RequestMapping("/test")
    public ResponseVo testAsyncTask(){
        return ResponseVo.success(asyncTaskClientService.addAsyncTask("test"));
    }

    @RequestMapping("/getTaskStatus")
    public ResponseVo getTaskStatus(String taskNo){
        return asyncTaskService.getTaskStatus(taskNo);
    }
}
