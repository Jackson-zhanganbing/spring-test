package com.changan.designpattern.pattern.behavior.interpreter;

/**
 * 解释器模式，表达式接口
 *
 * @author zab
 * @date 2024/11/13 22:22
 */
public interface Expression {
    /**
     * 解释
     */
    int interpret();
}
