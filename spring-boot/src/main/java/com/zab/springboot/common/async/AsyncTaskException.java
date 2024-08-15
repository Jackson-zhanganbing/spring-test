package com.zab.springboot.common.async;
/**
 * 异步任务相关异常
 *
 * @author zab
 * @date 2022/12/10 22:43
 */
public class AsyncTaskException extends RuntimeException{

    public AsyncTaskException() {
        super();
    }

    public AsyncTaskException(String message) {
        super(message);
    }
}
