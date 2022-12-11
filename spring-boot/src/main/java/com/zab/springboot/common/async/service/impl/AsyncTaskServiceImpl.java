package com.zab.springboot.common.async.service.impl;

import cn.hutool.core.thread.ThreadUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.conditions.query.QueryChainWrapper;
import com.zab.springboot.common.ResponseVo;
import com.zab.springboot.common.async.AsyncTaskMethod;
import com.zab.springboot.common.async.entity.AsyncTask;
import com.zab.springboot.common.async.mapper.AsyncTaskMapper;
import com.zab.springboot.common.async.service.IAsyncTaskService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 异步任务表 服务实现类
 * </p>
 *
 * @author zab
 * @since 2022-12-11
 */
@Service
@Slf4j
public class AsyncTaskServiceImpl extends ServiceImpl<AsyncTaskMapper, AsyncTask> implements IAsyncTaskService {

    @Autowired
    private AsyncTaskMapper asyncTaskMapper;

    @AsyncTaskMethod(taskCode = "test")
    public void testAsyncTask(String taskNo){
        //修改任务状态为running
        updateStatus(taskNo, 1);
        ThreadUtil.sleep(20000);
        updateStatus(taskNo, 2);
        log.info("异步任务测试~~~~~~~~~~~");
    }

    public void updateStatus(String taskNo, Integer status){
        asyncTaskMapper.updateByTaskNo(taskNo, status);
    }

    @Override
    public ResponseVo getTaskStatus(String taskNo) {
        QueryWrapper<AsyncTask> wrapper = new QueryWrapper();
        wrapper.select("status");
        wrapper.eq("task_no", taskNo);

        AsyncTask asyncTask = getOne(wrapper);

        return ResponseVo.success(asyncTask);
    }
}
