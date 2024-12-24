package com.changan.designpattern.pattern.behavior.state;

/**
 * 行驶状态
 *
 * @author zab
 * @date 2024/11/12 22:21
 */
public class DrivingState implements CarState{

    @Override
    public void showState(Car car) {
        car.setCarState(this);
    }

    @Override
    public String toString() {
        return "车辆处于行驶状态，请控制好方向";
    }
}
