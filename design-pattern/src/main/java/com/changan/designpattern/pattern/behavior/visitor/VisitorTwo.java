package com.changan.designpattern.pattern.behavior.visitor;

/**
 * 访问者2
 *
 * @author zab
 * @date 2024/11/12 22:53
 */
public class VisitorTwo implements IVisitor{

    @Override
    public void visit(SimData data) {
        System.out.println("访问者2，访问到SimData数据：" + data.getSimNo());
    }

    @Override
    public void visit(UserBaseData data) {
        System.out.println("访问者2，访问到UserBaseData数据：" + data.getUserName());
    }
}
