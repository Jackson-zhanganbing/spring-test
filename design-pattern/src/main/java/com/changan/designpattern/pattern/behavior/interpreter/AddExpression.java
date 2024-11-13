package com.changan.designpattern.pattern.behavior.interpreter;

/**
 * 加法解释器
 *
 * @author zab
 * @date 2024/11/13 22:24
 */
public class AddExpression implements Expression{

    private Expression leftExpression;

    private Expression rightExpression;

    public AddExpression(Expression leftExpression, Expression rightExpression) {
        this.leftExpression = leftExpression;
        this.rightExpression = rightExpression;
    }

    @Override
    public int interpret() {
        return leftExpression.interpret() + rightExpression.interpret();
    }
}
