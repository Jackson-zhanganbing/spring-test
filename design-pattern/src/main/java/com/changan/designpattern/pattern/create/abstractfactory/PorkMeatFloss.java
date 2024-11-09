package com.changan.designpattern.pattern.create.abstractfactory;

/**
 * 猪肉松
 *
 * @author zab
 * @date 2024/11/9 11:34
 */
public class PorkMeatFloss implements IMeatFloss {
    private String name;
    private String heat;

    public PorkMeatFloss(String name, String heat) {
        this.name = name;
        this.heat = heat;
    }

    public String getName() {
        return name;
    }

    public String getHeat() {
        return heat;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHeat(String heat) {
        this.heat = heat;
    }

    @Override
    public void doSomething() {
        System.out.println("获得" + name + "猪肉松~~~热量:" + heat);
    }
}
