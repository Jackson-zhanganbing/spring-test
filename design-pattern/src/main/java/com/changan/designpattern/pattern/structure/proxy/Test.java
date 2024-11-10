package com.changan.designpattern.pattern.structure.proxy;

/**
 * 代理模式测试
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
