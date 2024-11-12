package com.changan.designpattern.pattern.behavior.memento;

import java.util.ArrayList;
import java.util.List;

/**
 * 备忘录保管人
 *
 * @author zab
 * @date 2024/11/12 23:14
 */
public class Caretaker {

    List<Memento> mementos = new ArrayList<Memento>();

    public Memento getMemento(int i){
        return mementos.get(i);
    }

    public void setMemento(Memento memento){
        mementos.add(memento);
    }
}
