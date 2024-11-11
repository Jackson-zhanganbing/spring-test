package com.changan.designpattern.pattern.structure.flyweight;

/**
 * 享元模式测试
 * 其实核心思想就是重复用一个对象，不要每次用新的
 *
 * @author zab
 * @date 2024/11/11 23:09
 */
public class Test {
    public static void main(String[] args) {
        CarColorFactory colorFactory = new CarColorFactory();

        CarColor redColor = colorFactory.getCarColor("Red");
        CarColor blueColor = colorFactory.getCarColor("Blue");

        redColor.applyColor("Sedan");
        blueColor.applyColor("SUV");

        // 再次获取红色，应该是同一个对象
        CarColor anotherRedColor = colorFactory.getCarColor("Red");
        System.out.println("redColor == anotherRedColor: " + (redColor == anotherRedColor));
    }
}
