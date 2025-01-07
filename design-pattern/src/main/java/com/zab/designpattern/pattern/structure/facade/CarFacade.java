package com.zab.designpattern.pattern.structure.facade;

/**
 * 车辆 门面模式
 *
 * @author zab
 * @date 2024/11/11 22:51
 */
public class CarFacade {
    private Engine engine;
    private FuelSystem fuelSystem;
    private IgnitionSystem ignitionSystem;

    public CarFacade() {
        engine = new Engine();
        fuelSystem = new FuelSystem();
        ignitionSystem = new IgnitionSystem();
    }

    public void startCar() {
        System.out.println("Starting the car...");
        fuelSystem.pump();
        ignitionSystem.ignite();
        engine.run();
        System.out.println("Car is now running.");
    }
}
