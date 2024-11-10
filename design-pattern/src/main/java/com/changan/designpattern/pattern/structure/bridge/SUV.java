package com.changan.designpattern.pattern.structure.bridge;

/**
 * suv
 *
 * @author zab
 * @date 2024/11/10 12:21
 */
public class SUV extends AbstractCar {
    public SUV(IEngine iEngine) {
        super(iEngine);
    }

    @Override
    public void run() {
        iEngine.desc();
        System.out.println("SUV跑起来了");
    }
}
