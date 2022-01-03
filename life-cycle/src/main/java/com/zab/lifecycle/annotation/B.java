package com.zab.lifecycle.annotation;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * 生命周期测试类
 * 如果是原型模式，就不会执行生命周期的destroy方法
 *
 * @author zab
 * @date 2021-11-18 22:04
 */
@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class B implements BeanFactoryAware, BeanNameAware, InitializingBean, DisposableBean {

    public B() {
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
        System.out.println("9.afterPropertiesSet");
    }

    /**
     * 该注解表示初始化，跟xml的init方法一样
     */
    @PostConstruct
    public void init() {
        System.out.println("8.初始化init");
    }

}
