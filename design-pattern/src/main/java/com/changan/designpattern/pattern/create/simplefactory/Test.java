package com.changan.designpattern.pattern.create.simplefactory;

/**
 * 简单工厂测试
 *
 * @author zab
 * @date 2024/11/9 11:42
 */
public class Test {
    public static void main(String[] args) {
        ICar aCar = CarFactory.createProduct("A");
        aCar.run();

        ICar bCar = CarFactory.createProduct("B");
        bCar.run();
    }

}
