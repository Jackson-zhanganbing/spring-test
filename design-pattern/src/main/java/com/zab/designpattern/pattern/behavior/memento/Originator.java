package com.zab.designpattern.pattern.behavior.memento;

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
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Memento saveStateToMemento(){
        return new Memento(state);
    }

    /**
     * 恢复
     *
     */
    public void getStateFromMemento(Memento memento){
        state = memento.getState();
    }
}
