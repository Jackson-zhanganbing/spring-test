package com.zab.designpattern.pattern.behavior.command;

/**
 * 命令模式测试
 *
 * @author zab
 * @date 2024/11/13 22:05
 */
public class Test {
    public static void main(String[] args) {
        Car car = new Car();

        StartCarCommand startCarCommand = new StartCarCommand(car);
        BrakeCarCommand brakeCarCommand = new BrakeCarCommand(car);
        StopCarCommand stopCarCommand = new StopCarCommand(car);

        CommandInvoker commandInvoker = new CommandInvoker();
        commandInvoker.setCommand(startCarCommand);
        commandInvoker.callCommand();

        commandInvoker.setCommand(brakeCarCommand);
        commandInvoker.callCommand();

        commandInvoker.setCommand(stopCarCommand);
        commandInvoker.callCommand();
    }
}
