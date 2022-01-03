package com.zab.springboot.aop.proxy;

/**
 * 切面类
 *
 * @author zab
 * @date 2021-12-02 22:40
 */
public class Advice {
    public void before() {
        System.out.println("before==============");
    }

    public void after() {
        System.out.println("after==============");
    }
}
