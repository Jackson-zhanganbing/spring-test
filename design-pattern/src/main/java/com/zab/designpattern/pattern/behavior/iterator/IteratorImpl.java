package com.zab.designpattern.pattern.behavior.iterator;

import java.util.List;

/**
 * 迭代器实现
 *
 * @author zab
 * @date 2024/11/12 22:38
 */
public class IteratorImpl<E> implements MyIterator<E>{

    private List<E> list;
    private int position = 0;

    public IteratorImpl(List<E> list) {
        this.list = list;
    }

    @Override
    public boolean hasNext() {
        return position < list.size();
    }

    @Override
    public E next() {
        return list.get(position++);
    }
}
