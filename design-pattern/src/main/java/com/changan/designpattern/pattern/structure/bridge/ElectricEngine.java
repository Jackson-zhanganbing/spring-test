package com.changan.designpattern.pattern.structure.bridge;

/**
 * 电动引擎
 *
 * @author zab
 * @date 2024/11/10 12:17
 */
public class ElectricEngine implements IEngine{

    @Override
    public void desc() {
        System.out.println("电动引擎");
    }
}
