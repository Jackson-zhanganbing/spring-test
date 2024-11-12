package com.changan.designpattern.pattern.behavior.strategy;

/**
 * 男朋友
 *
 * @author zab
 * @date 2024/11/12 21:48
 */
public class Boyfriend {
    private CoaxGfStrategy coaxGfStrategy;


    public Boyfriend(CoaxGfStrategy coaxGfStrategy) {
        this.coaxGfStrategy = coaxGfStrategy;
    }

    public void setCoaxStrategy(CoaxGfStrategy coaxGfStrategy) {
        this.coaxGfStrategy = coaxGfStrategy;
    }

    public void coaxGirl(String message) {
        coaxGfStrategy.coax(message);
    }
}
