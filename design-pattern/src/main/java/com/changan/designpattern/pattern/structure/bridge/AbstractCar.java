package com.changan.designpattern.pattern.structure.bridge;

/**
 * 抽象 车辆
 *
 * @author zab
 * @date 2024/11/10 12:14
 */
public abstract class AbstractCar {
    protected IEngine iEngine;

    public AbstractCar(IEngine iEngine) {
        this.iEngine = iEngine;
    }

    /**
     * 跑起来
     */
    public abstract void run();
}
