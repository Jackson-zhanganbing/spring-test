package com.changan.designpattern.pattern.behavior.strategy;
/**
 * 策略模式测试
 *
 * @author zab
 * @date 2024/11/12 21:49
 */
public class Test {
    public static void main(String[] args) {
        Boyfriend boyfriend = new Boyfriend(new ComplimentStrategy());
        boyfriend.coaxGirl("我不是魔镜，我不会骗你的！");

        boyfriend = new Boyfriend(new CareStrategy());
        boyfriend.coaxGirl("别难过了！");

        boyfriend = new Boyfriend(new FunStrategy());
        boyfriend.coaxGirl("最近新上映的！");

    }
}
