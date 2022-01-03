package com.zab.lifecycle.annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * 注解生命周期测试类
 *
 * @author zab
 * @date 2021-11-19 22:00
 */
@Configuration
@ComponentScan
public class AnnotationTest {
    public static void main(String[] args) {
        ApplicationContext factory = new AnnotationConfigApplicationContext(AnnotationTest.class);
        B b = factory.getBean(B.class);

        ((AnnotationConfigApplicationContext) factory).close();
    }
}
