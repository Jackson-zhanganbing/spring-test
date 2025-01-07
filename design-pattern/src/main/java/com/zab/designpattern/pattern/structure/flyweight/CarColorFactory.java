package com.zab.designpattern.pattern.structure.flyweight;

import java.util.HashMap;
import java.util.Map;

/**
 * 享元工厂
 *
 * @author zab
 * @date 2024/11/11 23:08
 */
public class CarColorFactory {
    private Map<String, CarColor> colorMap = new HashMap<String, CarColor>();

    public CarColor getCarColor(String color) {
        CarColor carColor = colorMap.get(color);
        if (carColor == null) {
            carColor = new ConcreteCarColor(color);
            colorMap.put(color, carColor);
        }
        return carColor;
    }
}
