package com.zab.lifecycle.xml;

import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;

import java.beans.PropertyDescriptor;
/**
 * 针对Bean增强，主要是实例化前后
 *
 * @author zab
 * @date 2021-11-18 22:04
 */
public class MyInstantiationAwareBeanPostProcessor implements InstantiationAwareBeanPostProcessor {
    @Override
    public Object postProcessBeforeInstantiation(Class beanClass,
                                                 String beanName) throws BeansException {
        System.out.println("2.InstantiationAwareBeanPostProcessor调用postProcessBeforeInstantiation方法");
        return null;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName)
            throws BeansException {
        System.out.println("11.InstantiationAwareBeanPostProcessor调用postProcessAfterInitialization方法");
        return bean;
    }

    // 接口方法、设置某个属性时调用
    @Override
    public PropertyValues postProcessPropertyValues(PropertyValues pvs,
                                                    PropertyDescriptor[] pds, Object bean, String beanName)
            throws BeansException {
        System.out.println("4.InstantiationAwareBeanPostProcessor调用postProcessPropertyValues方法");
        return pvs;
    }
}
