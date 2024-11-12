package com.changan.designpattern.pattern.behavior.state;

/**
 * 状态模式测试
 *
 * @author zab
 * @date 2024/11/12 22:27
 */
public class Test {
    public static void main(String[] args) {
        Car car = new Car(new StopState());

        car.driving();
        car.getCarState();

        car.braking();
        car.getCarState();

        car.stop();
        car.getCarState();
    }
}
