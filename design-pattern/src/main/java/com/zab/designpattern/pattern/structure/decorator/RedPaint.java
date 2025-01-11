package com.zab.designpattern.pattern.structure.decorator;

/**
 * 红色的车漆
 *
 * @author zab
 * @date 2024/11/11 21:40
 */
public class RedPaint extends CarDecorator{

    private ICar car;

    public RedPaint(ICar car) {
        this.car = car;
    }

    @Override
    public String getDesc() {
        return "red paint " + car.getDesc();
    }
}