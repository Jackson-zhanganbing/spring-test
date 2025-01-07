package com.zab.designpattern.pattern.structure.decorator;

/**
 * 装饰器测试
 *
 * @author zab
 * @date 2024/11/11 21:42
 */
public class Test {
    public static void main(String[] args) {
        //用白色的漆，装饰具体的车辆
        WhitePaint whitePaint = new WhitePaint(new ConcreteCar());
        System.out.println(whitePaint.getDesc());

        //用白色的漆，装饰具体的车辆
        RedPaint redPaint = new RedPaint(new ConcreteCar());
        System.out.println(redPaint.getDesc());
    }
}
