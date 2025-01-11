package com.zab.designpattern.pattern.behavior.strategy;
/**
 * 赞美策略
 *
 * @author zab
 * @date 2024/11/12 21:45
 */
public class ComplimentStrategy implements CoaxGfStrategy{

    @Override
    public void coax(String something) {
        System.out.println("我觉得你长得好像紫霞仙子啊！" + something);
    }
}
