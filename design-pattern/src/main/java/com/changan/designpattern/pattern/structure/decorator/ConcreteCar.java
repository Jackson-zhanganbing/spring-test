package com.changan.designpattern.pattern.structure.decorator;

/**
 * 具体的车辆
 *
 * @author zab
 * @date 2024/11/11 21:36
 */
public class ConcreteCar implements ICar{

    @Override
    public String getDesc() {
        return "concrete car";
    }
}
