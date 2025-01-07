package com.zab.designpattern.pattern.structure.adapter;

/**
 * 点烟器实现
 *
 * @author zab
 * @date 2024/11/11 22:16
 */
public class CigaretteLighterImpl implements ICigaretteLighter{
    @Override
    public void supplyPower() {
        System.out.println("点烟器提供能源");
    }
}
