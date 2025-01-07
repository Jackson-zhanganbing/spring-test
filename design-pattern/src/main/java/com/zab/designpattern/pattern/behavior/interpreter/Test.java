package com.zab.designpattern.pattern.behavior.interpreter;

/**
 * 解释器模式测试
 *
 * @author zab
 * @date 2024/11/13 22:36
 */
public class Test {
    public static void main(String[] args) {
        String input = "3 5 + 4 -";

        ExpressionParser expressionParser = new ExpressionParser();
        Expression parse = expressionParser.parse(input);
        System.out.println(parse.interpret());
    }
}
