package com.zab.designpattern.pattern.create.abstractfactory;

/**
 * 小麦煎饼
 *
 * @author zab
 * @date 2024/11/9 11:34
 */
public class WheatPancake implements IPancake {
    private String name;
    private String heat;

    public WheatPancake(String name, String heat) {
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
        System.out.println("获得一个" + name + "小麦煎饼~~~热量:" + heat);
    }
}
