package com.zab.designpattern.pattern.create.factory;

/**
 * 工厂模式测试
 *
 * @author zab
 * @date 2024/11/9 11:42
 */
public class Test {
    public static void main(String[] args) {
        CarFactory aCarFactory = new ACarFactory();
        ICar aCar = aCarFactory.createProduct();
        aCar.run();

        CarFactory bCarFactory = new BCarFactory();
        ICar bCar = bCarFactory.createProduct();
        bCar.run();

    }

}
