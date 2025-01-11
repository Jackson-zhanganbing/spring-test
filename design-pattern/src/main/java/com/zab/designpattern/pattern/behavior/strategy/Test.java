package com.zab.designpattern.pattern.behavior.strategy;
/**
 * 策略模式测试
 *
 * @author zab
 * @date 2024/11/12 21:49
 */
public class Test {
    public static void main(String[] args) {
        Boyfriend boyfriend = new Boyfriend(new ComplimentStrategy());
        boyfriend.coaxGirl("【PS：先发个1314红包。】");

        boyfriend = new Boyfriend(new CareStrategy());
        boyfriend.coaxGirl("【PS：先发个520红包。】");

        boyfriend = new Boyfriend(new FunStrategy());
        boyfriend.coaxGirl("【PS：先发个10001红包。】");

    }
}
