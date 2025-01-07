package com.zab.designpattern.pattern.structure.decorator;

/**
 * 车辆装饰器
 *
 * @author zab
 * @date 2024/11/11 21:38
 */
public abstract class CarDecorator implements ICar {

    private ICar car;

    public abstract String getDesc();
}
