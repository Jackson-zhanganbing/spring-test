package com.zab.designpattern.pattern.behavior.template;

/**
 * 学习知识模板
 *
 * @author zab
 * @date 2024/11/12 21:16
 */
public abstract class KnowledgeLearner {
    public final void learn(){
        preview();
        visitClass();
        review();
        practice();
        teach();
        System.out.println("终于学会了！");
    }

    public void preview(){
        System.out.println("预习");
    }

    /**
     * 听课
     */
    public abstract void visitClass();

    /**
     * 复习
     */
    public abstract void review();

    /**
     * 练习
     */
    public abstract void practice();

    /**
     * 教别人
     */
    public abstract void teach();
}
