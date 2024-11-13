package com.changan.designpattern.pattern.behavior.command;

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

        CarRemoteControl carRemoteControl = new CarRemoteControl();
        carRemoteControl.setCommand(startCarCommand);
        carRemoteControl.callCommand();

        carRemoteControl.setCommand(brakeCarCommand);
        carRemoteControl.callCommand();

        carRemoteControl.setCommand(stopCarCommand);
        carRemoteControl.callCommand();
    }
}
