package com.zab.designpattern.pattern.behavior.visitor;

/**
 * 访问者模式测试
 *
 * @author zab
 * @date 2024/11/12 22:54
 */
public class Test {
    public static void main(String[] args) {
        VisitorOne visitorOne = new VisitorOne();
        VisitorTwo visitorTwo = new VisitorTwo();

        UserBaseData userBaseData = new UserBaseData();
        userBaseData.setUserName("zhangsan");

        SimData simData = new SimData();
        simData.setSimNo("111111");

        userBaseData.accept(visitorOne);
        simData.accept(visitorOne);
        System.out.println("==================");
        userBaseData.accept(visitorTwo);
        simData.accept(visitorTwo);

    }
}
