package com.zab.designpattern.pattern.behavior.interpreter;

/**
 * 数字解释器
 *
 * @author zab
 * @date 2024/11/13 22:24
 */
public class NumberExpression implements Expression{

    private int number;

    public NumberExpression(int number) {
        this.number = number;
    }

    @Override
    public int interpret() {
        return number;
    }
}
