package com.zab.designpattern.pattern.behavior.state;

/**
 * 行驶状态
 *
 * @author zab
 * @date 2024/11/12 22:21
 */
public class DrivingState implements CarState{

    @Override
    public void doAction(Car car) {
        car.setCarState(this);
    }

    @Override
    public String toString() {
        return "车辆处于行驶状态，请控制好方向";
    }
}
