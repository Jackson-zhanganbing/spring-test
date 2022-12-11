package com.zab.springboot.common.async;

import lombok.Data;

import java.lang.reflect.Method;

/**
 * 真实任务，包含方法，对象
 *
 * @author zab
 * @date 2022/12/11 1:56
 */
@Data
public class RealTask {

    private Method method;

    private Object object;

    private String taskCode;
}
