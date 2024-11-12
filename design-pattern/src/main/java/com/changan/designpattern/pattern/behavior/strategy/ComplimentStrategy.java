package com.changan.designpattern.pattern.behavior.strategy;
/**
 * 赞美策略
 *
 * @author zab
 * @date 2024/11/12 21:45
 */
public class ComplimentStrategy implements CoaxGfStrategy{

    @Override
    public void coax(String something) {
        System.out.println("我觉得你是世界上最美丽的女孩！" + something);
    }
}
