package com.changan.designpattern.pattern.behavior.state;

/**
 * 行驶状态
 *
 * @author zab
 * @date 2024/11/12 22:21
 */
public class DrivingState implements CarState{

    @Override
    public void showState() {
        System.out.println("车辆处于行驶状态，请控制好方向");
    }
}
