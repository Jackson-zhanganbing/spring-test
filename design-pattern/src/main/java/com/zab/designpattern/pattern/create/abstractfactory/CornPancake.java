package com.zab.designpattern.pattern.create.abstractfactory;

/**
 * 玉米煎饼
 *
 * @author zab
 * @date 2024/11/9 11:34
 */
public class CornPancake implements IPancake {
    private String name;
    private String heat;

    public CornPancake(String name, String heat) {
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
        System.out.println("获得一个" + name + "玉米煎饼~~~热量:" + heat);
    }
}
