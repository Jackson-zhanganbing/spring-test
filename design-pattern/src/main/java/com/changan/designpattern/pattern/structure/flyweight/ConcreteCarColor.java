package com.changan.designpattern.pattern.structure.flyweight;

/**
 * 具体车辆颜色
 *
 * @author zab
 * @date 2024/11/11 23:08
 */
public class ConcreteCarColor implements CarColor {
    private String color;

    public ConcreteCarColor(String color) {
        this.color = color;
    }

    @Override
    public void applyColor(String carType) {
        System.out.println("Color " + color + " applied to " + carType);
    }
}
