package com.zab.springboot.common.async;

import java.lang.annotation.*;

/**
 * 标记方法为异步任务方法，需要写方法名
 *
 * @author zab
 * @date 2022/12/10 21:17
 */
@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface AsyncTaskMethod {
    /**
     * 任务code
     *
     * @author zab
     * @date 2022/12/10 21:22
     */
    String taskCode();

}
