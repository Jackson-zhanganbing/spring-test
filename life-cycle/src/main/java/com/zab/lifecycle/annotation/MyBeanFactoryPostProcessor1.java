package com.zab.lifecycle.annotation;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

/**
 * 针对BeanDefinition增强
 *
 * @author zab
 * @date 2021-11-18 22:04
 */
@Component
public class MyBeanFactoryPostProcessor1 implements BeanFactoryPostProcessor {

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
        System.out.println("1.BeanFactoryPostProcessor调用postProcessBeanFactory方法");
    }
}
