package com.zab.designpattern.pattern.behavior.strategy;
/**
 * 娱乐策略
 *
 * @author zab
 * @date 2024/11/12 21:45
 */
public class FunStrategy implements CoaxGfStrategy{

    @Override
    public void coax(String something) {
        System.out.println("我们去看一下大话西游吧！" + something);
    }
}
