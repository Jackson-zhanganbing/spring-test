package com.zab.designpattern.pattern.create.abstractfactory;

/**
 * 鸡肉松-玉米煎饼 工厂
 *
 * @author zab
 * @date 2024/11/9 21:28
 */
public class ChickenMeatFlossCornPancakeFactory implements IPancakeMeatFlossFactory {

    @Override
    public IPancake producePancake() {
        return new CornPancake("1年玉米", "100千卡");
    }

    @Override
    public IMeatFloss produceMeatFloss() {
        return new ChickenMeatFloss("5月肥鸡", "100千卡");
    }
}
