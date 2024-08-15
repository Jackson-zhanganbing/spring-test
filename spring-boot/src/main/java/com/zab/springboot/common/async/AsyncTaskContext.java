package com.zab.springboot.common.async;

import com.zab.springboot.common.async.entity.AsyncTask;
import lombok.Data;

/**
 * 异步任务上下文
 *
 * @author zab
 * @date 2022/12/11 1:18
 */
@Data
public class AsyncTaskContext {

    private AsyncTask asyncTask;

    private String taskCode;
}
