package com.zab.lifecycle.xml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * xml生命周期测试类
 *
 * @author zab
 * @date 2021-11-19 22:00
 */
public class XmlTest {
    public static void main(String[] args) {
        ApplicationContext factory = new ClassPathXmlApplicationContext("classpath:beans.xml");
        System.out.println("容器初始化成功");
        A a = factory.getBean(A.class);

        ((ClassPathXmlApplicationContext) factory).close();
    }
}
