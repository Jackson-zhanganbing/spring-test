package com.zab.designpattern.pattern.behavior.command;

/**
 * 远控
 *
 * @author zab
 * @date 2024/11/13 22:00
 */
public class CommandInvoker {

    private CarCommand command;

    public void setCommand(CarCommand command){
        this.command = command;
    }

    public void callCommand(){
        command.execute();
    }

}
