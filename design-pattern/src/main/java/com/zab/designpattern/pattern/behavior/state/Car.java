package com.zab.designpattern.pattern.behavior.state;

/**
 * 车辆类
 *
 * @author zab
 * @date 2024/11/12 22:24
 */
public class Car {
    private CarState carState;

    public Car(CarState carState) {
        this.carState = carState;
    }

    public void setCarState(CarState carState) {
        this.carState = carState;
    }

    public CarState getCarState(){
        return carState;
    }
}
