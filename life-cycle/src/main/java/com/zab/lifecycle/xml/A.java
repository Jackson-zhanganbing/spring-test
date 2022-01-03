package com.zab.lifecycle.xml;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;

/**
 * 生命周期测试类
 *
 * @author zab
 * @date 2021-11-18 22:04
 */
public class A implements BeanFactoryAware, BeanNameAware, InitializingBean, DisposableBean {

    public A() {
        System.out.println("3.实例化");
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("6.Aware设置属性：beanFactory");
    }

    @Override
    public void setBeanName(String s) {
        System.out.println("5.Aware设置属性：setBeanName");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("12.destroy");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("8.afterPropertiesSet");
    }

    public void init() {
        System.out.println("9.初始化init");
    }

}
