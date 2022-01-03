package com.zab.lifecycle.annotation;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * 针对Bean增强，主要是初始化前后
 *
 * @author zab
 * @date 2021-11-18 22:04
 */
@Component
public class MyBeanPostProcessor1 implements BeanPostProcessor {

    @Override
    public Object postProcessAfterInitialization(Object arg0, String arg1)
            throws BeansException {
        System.out.println("10.BeanPostProcessor接口方法postProcessAfterInitialization对属性进行更改！");
        return arg0;
    }

    @Override
    public Object postProcessBeforeInitialization(Object arg0, String arg1)
            throws BeansException {
        System.out.println("7.BeanPostProcessor接口方法postProcessBeforeInitialization对属性进行更改！");
        return arg0;
    }
}
