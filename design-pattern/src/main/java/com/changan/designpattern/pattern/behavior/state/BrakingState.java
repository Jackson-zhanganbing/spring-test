package com.changan.designpattern.pattern.behavior.state;

/**
 * 刹车状态
 *
 * @author zab
 * @date 2024/11/12 22:21
 */
public class BrakingState implements CarState{

    @Override
    public void showState() {
        System.out.println("车辆处于刹车状态，请控制好方向");
    }
}
