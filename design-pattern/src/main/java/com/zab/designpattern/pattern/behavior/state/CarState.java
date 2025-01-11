package com.zab.designpattern.pattern.behavior.state;

/**
 * 车辆状态接口
 *
 * @author zab
 * @date 2024/11/12 22:20
 */
public interface CarState {

    /**
     * 操作
     */
    void doAction(Car car);
}
