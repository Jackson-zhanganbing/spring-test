package com.changan.designpattern.pattern.behavior.memento;

/**
 * 备忘录发起人
 *
 * @author zab
 * @date 2024/11/12 23:14
 */
public class Originator {

    private String state;

    public Originator(String state) {
        this.state = state;
        System.out.println("发起人的状态：" + state);
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
        System.out.println("发起人的状态：" + state);
    }

    public Memento saveStateToMemento(){
        return new Memento(state);
    }
    public String getStateFromMemento(Memento memento){
        this.setState(memento.getState());
        return this.getState();
    }
}
