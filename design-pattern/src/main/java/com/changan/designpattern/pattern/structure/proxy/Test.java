package com.changan.designpattern.pattern.structure.proxy;

/**
 * 代理模式测试
 * 代理模式中引入了一个新的代理对象,代理对象在客户端对象和目标对象之间起到了中介的作用,它去掉客户不能看到的内容和服务或者增加客户需要的额外的新服务.
 * 优势：可以在不修改目标对象的前提下扩展目标对象的功能。
 *
 * @author zab
 * @date 2024/11/10 11:21
 */
public class Test {
    public static void main(String[] args) {
        Driver driver = new ProxyDriver();
        driver.goHome();
    }
}
