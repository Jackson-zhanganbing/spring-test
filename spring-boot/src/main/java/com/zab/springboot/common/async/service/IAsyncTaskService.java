package com.zab.springboot.common.async.service;

import com.zab.springboot.common.ResponseVo;
import com.zab.springboot.common.async.entity.AsyncTask;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 异步任务表 服务类
 * </p>
 *
 * @author zab
 * @since 2022-12-11
 */
public interface IAsyncTaskService extends IService<AsyncTask> {

    ResponseVo getTaskStatus(String taskNo);
}
