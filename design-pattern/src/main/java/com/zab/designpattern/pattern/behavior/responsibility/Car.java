package com.zab.designpattern.pattern.behavior.responsibility;

/**
 * 车辆，包含一些检查项
 *
 * @author zab
 * @date 2024/11/12 22:06
 */
public class Car {
    private int oilLevel;
    private double tirePressure;

    public Car(int oilLevel, double tirePressure) {
        this.oilLevel = oilLevel;
        this.tirePressure = tirePressure;
    }

    public int getOilLevel() {
        return oilLevel;
    }

    public double getTirePressure() {
        return tirePressure;
    }
}
