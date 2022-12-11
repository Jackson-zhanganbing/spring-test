package com.zab.springboot.common.async.service.impl;

import cn.hutool.core.thread.ThreadUtil;
import com.zab.springboot.common.async.AsyncTaskMethod;
import com.zab.springboot.common.async.entity.AsyncTask;
import com.zab.springboot.common.async.mapper.AsyncTaskMapper;
import com.zab.springboot.common.async.service.IAsyncTaskService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
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
    @AsyncTaskMethod(taskCode = "test")
    public void testZab1(){
        ThreadUtil.sleep(2000);
        log.info("异步任务测试~~~~~~~~~~~");
    }
}
