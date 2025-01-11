package com.zab.designpattern.pattern.behavior.state;

/**
 * 状态模式测试
 *
 * @author zab
 * @date 2024/11/12 22:27
 */
public class Test {
    public static void main(String[] args) {
        Car car = new Car();

        DrivingState drivingState = new DrivingState();
        drivingState.doAction(car);

        car.doDriving();

        BrakingState brakingState = new BrakingState();
        brakingState.doAction(car);

        car.doDriving();

        StopState stopState = new StopState();
        stopState.doAction(car);

        car.doDriving();
    }
}
