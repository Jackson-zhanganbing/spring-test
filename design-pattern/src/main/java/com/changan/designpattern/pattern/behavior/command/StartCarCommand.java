package com.changan.designpattern.pattern.behavior.command;

/**
 * 启动汽车指令
 *
 * @author zab
 * @date 2024/11/13 21:57
 */
public class StartCarCommand implements CarCommand{

    private Car car;

    public StartCarCommand(Car car) {
        this.car = car;
    }

    @Override
    public void execute() {
        car.start();
    }
}
