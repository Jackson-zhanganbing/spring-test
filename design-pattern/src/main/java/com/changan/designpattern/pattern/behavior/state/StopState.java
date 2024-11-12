package com.changan.designpattern.pattern.behavior.state;

/**
 * 停止状态
 *
 * @author zab
 * @date 2024/11/12 22:21
 */
public class StopState implements CarState{

    @Override
    public void showState() {
        System.out.println("车辆处于停止状态，请手刹");
    }
}
