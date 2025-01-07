package com.zab.designpattern.pattern.behavior.template;

/**
 * 学习者2
 *
 * @author zab
 * @date 2024/11/12 21:22
 */
public class LearnerTwo extends KnowledgeLearner{
    @Override
    public void visitClass() {
        System.out.println("学习者2听课中···");
    }

    @Override
    public void review() {
        System.out.println("学习者2复习中···");
    }

    @Override
    public void practice() {
        System.out.println("学习者2练习中···");
    }

    @Override
    public void teach() {
        System.out.println("学习者2给别人讲课中···");
    }
}
