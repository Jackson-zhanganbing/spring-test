package com.changan.designpattern.pattern.behavior.state;

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

    public void stop(){
        System.out.println("车辆停止");
        this.setCarState(new StopState());
    }
    public void driving(){
        System.out.println("车辆行驶");
        this.setCarState(new DrivingState());
    }
    public void braking(){
        System.out.println("车辆刹车");
        this.setCarState(new BrakingState());
    }

    public void getCarState(){
        carState.showState();
    }
}
