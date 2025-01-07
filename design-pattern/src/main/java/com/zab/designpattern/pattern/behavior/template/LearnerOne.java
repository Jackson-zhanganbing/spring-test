package com.zab.designpattern.pattern.behavior.template;

/**
 * 学习者1
 *
 * @author zab
 * @date 2024/11/12 21:22
 */
public class LearnerOne extends KnowledgeLearner{
    @Override
    public void visitClass() {
        System.out.println("学习者1听课中···");
    }

    @Override
    public void review() {
        System.out.println("学习者1复习中···");
    }

    @Override
    public void practice() {
        System.out.println("学习者1练习中···");
    }

    @Override
    public void teach() {
        System.out.println("学习者1给别人讲课中···");
    }
}
