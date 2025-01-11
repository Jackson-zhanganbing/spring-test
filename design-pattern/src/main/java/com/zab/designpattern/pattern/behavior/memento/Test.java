package com.zab.designpattern.pattern.behavior.memento;

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
        System.out.println("发起人的状态：" + originator.getState());
        //把开心存起来
        caretaker.setMemento(originator.saveStateToMemento());

        originator.setState("委屈");
        caretaker.setMemento(originator.saveStateToMemento());
        System.out.println("发起人的状态：" + originator.getState());

        originator.setState("难过");
        caretaker.setMemento(originator.saveStateToMemento());
        System.out.println("发起人的状态：" + originator.getState());

        //恢复开心状态
        originator.getStateFromMemento(caretaker.getMemento(0));
        System.out.println("发起人的状态：" + originator.getState());
    }
}
