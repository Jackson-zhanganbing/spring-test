package com.zab.designpattern.pattern.structure.proxy;

/**
 * 具体的某一个司机
 *
 * @author zab
 * @date 2024/11/10 11:11
 */
public class ConcreteDriver implements Driver {

    @Override
    public void goHome() {
        System.out.println("开车回家");
    }

}
