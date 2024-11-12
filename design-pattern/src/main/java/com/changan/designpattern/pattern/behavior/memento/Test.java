package com.changan.designpattern.pattern.behavior.memento;

/**
 * 备忘录模式测试
 *
 * @author zab
 * @date 2024/11/12 23:19
 */
public class Test {
    public static void main(String[] args) {
        Originator originator = new Originator("开心");
        Caretaker caretaker = new Caretaker();

        //把开心存起来
        caretaker.setMemento(originator.saveStateToMemento());

        originator.setState("委屈");
        caretaker.setMemento(originator.saveStateToMemento());

        originator.setState("难过");
        caretaker.setMemento(originator.saveStateToMemento());

        //恢复开心状态
        originator.getStateFromMemento(caretaker.getMemento(0));
    }
}
