package com.changan.designpattern.pattern.create.abstractfactory;

/**
 * 抽象工厂模式测试
 *
 * @author zab
 * @date 2024/11/9 11:42
 */
public class Test {
    public static void main(String[] args) {
        IPancakeMeatFlossFactory porkMeatFlossWheatPancakeFactory = new PorkMeatFlossWheatPancakeFactory();
        IMeatFloss iMeatFloss = porkMeatFlossWheatPancakeFactory.produceMeatFloss();
        IPancake iPancake = porkMeatFlossWheatPancakeFactory.producePancake();

        iMeatFloss.doSomething();
        iPancake.doSomething();



        IPancakeMeatFlossFactory chickMeatFlossCornPancakeFactory = new ChickenMeatFlossCornPancakeFactory();
        IMeatFloss iMeatFloss1 = chickMeatFlossCornPancakeFactory.produceMeatFloss();
        IPancake iPancake1 = chickMeatFlossCornPancakeFactory.producePancake();

        iMeatFloss1.doSomething();
        iPancake1.doSomething();


    }

}
