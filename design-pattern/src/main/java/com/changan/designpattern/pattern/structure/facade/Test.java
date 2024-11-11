package com.changan.designpattern.pattern.structure.facade;
/**
 * 门面模式
 * 外观模式的主要目的是隐藏系统的复杂性，简化对系统的使用。
 *
 * @author zab
 * @date 2024/11/11 22:53
 */
public class Test {
    public static void main(String[] args) {
        CarFacade carFacade = new CarFacade();
        carFacade.startCar();
    }
}
