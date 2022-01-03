package com.zab.lifecycle.xml;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

/**
 * 针对BeanDefinition增强
 *
 * @author zab
 * @date 2021-11-18 22:04
 */
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
        System.out.println("1.BeanFactoryPostProcessor调用postProcessBeanFactory方法");
    }
}
