package com.changan.designpattern.pattern.behavior.strategy;
/**
 * 关心策略
 *
 * @author zab
 * @date 2024/11/12 21:45
 */
public class CareStrategy implements CoaxGfStrategy{

    @Override
    public void coax(String something) {
        System.out.println("你还好吗？如果有需要我会在这里陪着你。" + something);
    }
}
