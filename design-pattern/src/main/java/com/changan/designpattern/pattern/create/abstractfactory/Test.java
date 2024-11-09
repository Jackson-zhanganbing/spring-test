package com.changan.designpattern.pattern.create.abstractfactory;

/**
 * 抽象工厂模式测试
 *
 * @author zab
 * @date 2024/11/9 11:42
 */
public class Test {
    public static void main(String[] args) {
        AbstractCarFactory factory1 = new Factory1();
        ICarA iCarA1 = factory1.productACar();
        ICarB iCarB1 = factory1.productBCar();
        iCarA1.run();
        iCarB1.run();


        AbstractCarFactory factory2 = new Factory2();
        ICarA iCarA2 = factory2.productACar();
        ICarB iCarB2 = factory2.productBCar();
        iCarA2.run();
        iCarB2.run();
    }

}
