package com.changan.designpattern.pattern.behavior.interpreter;

import java.util.Stack;

/**
 * 表达式解析器
 *
 * @author zab
 * @date 2024/11/13 22:29
 */
public class ExpressionParser {

    public Expression parse(String tokenStr){
        Stack<Expression> stack = new Stack<Expression>();
        String[] tokens = tokenStr.split(" ");

        for (String token : tokens) {
            switch (token){
                case "+" :
                    Expression rightExpression1 = stack.pop();
                    Expression leftExpression1 = stack.pop();

                    stack.push(new AddExpression(leftExpression1, rightExpression1));
                    break;
                case "-" :
                    Expression rightExpression2 = stack.pop();
                    Expression leftExpression2 = stack.pop();

                    stack.push(new SubtractExpression(leftExpression2, rightExpression2));
                    break;
                default:
                    stack.push(new NumberExpression(Integer.parseInt(token)));
                    break;
            }

        }
        return stack.pop();
    }

}
