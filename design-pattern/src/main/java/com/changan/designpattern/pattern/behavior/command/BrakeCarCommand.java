package com.changan.designpattern.pattern.behavior.command;

/**
 * 汽车刹车指令
 *
 * @author zab
 * @date 2024/11/13 21:57
 */
public class BrakeCarCommand implements CarCommand{

    private Car car;

    public BrakeCarCommand(Car car) {
        this.car = car;
    }

    @Override
    public void execute() {
        car.brake();
    }
}
