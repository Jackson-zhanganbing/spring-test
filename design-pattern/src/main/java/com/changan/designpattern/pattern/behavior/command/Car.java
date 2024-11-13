package com.changan.designpattern.pattern.behavior.command;

/**
 * 汽车
 *
 * @author zab
 * @date 2024/11/13 21:55
 */
public class Car {
    public void stop(){
        System.out.println("汽车停止指令");
    }
    public void start(){
        System.out.println("汽车启动指令");
    }
    public void brake(){
        System.out.println("汽车刹车指令");
    }
}
