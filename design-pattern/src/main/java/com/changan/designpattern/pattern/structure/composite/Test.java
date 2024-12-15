package com.changan.designpattern.pattern.structure.composite;

/**
 * 组合模式
 *
 * @author zab
 * @date 2024/11/11 23:02
 */
public class Test {
    public static void main(String[] args) {
        Car car = new Car();

        ICarComponent engine = new Engine();
        ICarComponent tire1 = new Tire();
        ICarComponent tire2 = new Tire();

        car.addComponent(engine);
        car.addComponent(tire1);
        car.addComponent(tire2);

        car.showDetails();
    }
}
