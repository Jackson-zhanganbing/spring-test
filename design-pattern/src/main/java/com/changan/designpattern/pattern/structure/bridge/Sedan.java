package com.changan.designpattern.pattern.structure.bridge;

/**
 * 小轿车
 *
 * @author zab
 * @date 2024/11/10 12:21
 */
public class Sedan extends AbstractCar {
    public Sedan(IEngine iEngine) {
        super(iEngine);
    }

    @Override
    public void run() {
        iEngine.desc();
        System.out.println("小轿车跑起来了");
    }
}
