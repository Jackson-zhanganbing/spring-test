package com.changan.designpattern.pattern.behavior.interpreter;

/**
 * 减法解释器
 *
 * @author zab
 * @date 2024/11/13 22:24
 */
public class SubtractExpression implements Expression{

    private Expression leftExpression;

    private Expression rightExpression;

    public SubtractExpression(Expression leftExpression, Expression rightExpression) {
        this.leftExpression = leftExpression;
        this.rightExpression = rightExpression;
    }

    @Override
    public int interpret() {
        return leftExpression.interpret() - rightExpression.interpret();
    }
}
