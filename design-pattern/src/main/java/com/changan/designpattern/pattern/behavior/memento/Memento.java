package com.changan.designpattern.pattern.behavior.memento;

/**
 * 备忘录
 *
 * @author zab
 * @date 2024/11/12 23:14
 */
public class Memento {
    private String state;

    public Memento(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
