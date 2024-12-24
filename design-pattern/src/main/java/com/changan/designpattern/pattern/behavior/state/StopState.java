package com.changan.designpattern.pattern.behavior.state;

/**
 * 停止状态
 *
 * @author zab
 * @date 2024/11/12 22:21
 */
public class StopState implements CarState{

    @Override
    public void showState(Car car) {
        car.setCarState(this);
    }
    @Override
    public String toString() {
        return "车辆处于停止状态，请手刹";
    }
}
