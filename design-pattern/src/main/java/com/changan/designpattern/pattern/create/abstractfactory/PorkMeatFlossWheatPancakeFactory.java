package com.changan.designpattern.pattern.create.abstractfactory;

/**
 * 猪肉松-小麦煎饼 工厂
 *
 * @author zab
 * @date 2024/11/9 21:28
 */
public class PorkMeatFlossWheatPancakeFactory implements AbstractPancakeFactory {

    @Override
    public IPancake producePancake() {
        return new WheatPancake("1年精小麦", "100千卡");
    }

    @Override
    public IMeatFloss produceMeatFloss() {
        return new PorkMeatFloss("2年肥猪", "100千卡");
    }
}
