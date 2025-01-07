package com.zab.designpattern.pattern.behavior.template;

/**
 * 模板方法设计模式测试
 *
 * @author zab
 * @date 2024/11/12 21:24
 */
public class Test {
    public static void main(String[] args) {
        LearnerOne learnerOne = new LearnerOne();
        LearnerTwo learnerTwo = new LearnerTwo();

        learnerOne.learn();
        System.out.println("=============");
        learnerTwo.learn();

    }
}
