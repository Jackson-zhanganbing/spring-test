package com.changan.designpattern.pattern.structure.decorator;

/**
 * 白色的车漆
 *
 * @author zab
 * @date 2024/11/11 21:40
 */
public class WhitePaint extends CarDecorator{

    private ICar car;

    public WhitePaint(ICar car) {
        this.car = car;
    }

    @Override
    public String getDesc() {
        return "white paint " + car.getDesc();
    }
}
