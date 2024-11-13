package com.changan.designpattern.pattern.behavior.command;

/**
 * 停止汽车指令
 *
 * @author zab
 * @date 2024/11/13 21:57
 */
public class StopCarCommand implements CarCommand{

    private Car car;

    public StopCarCommand(Car car) {
        this.car = car;
    }

    @Override
    public void execute() {
        car.stop();
    }
}
