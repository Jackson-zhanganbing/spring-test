package com.zab.designpattern.pattern.behavior.iterator;

/**
 * 定义迭代器
 *
 * @author zab
 * @date 2024/11/12 22:36
 */
public interface MyIterator<E> {

    /**
     * 是否还有元素
     *
     * @return boolean yes 有
     */
    boolean hasNext();

    /**
     * 获取下一个元素
     * @return E 元素
     */
    E next();
}
