package com.zab.designpattern.pattern.behavior.visitor;

/**
 * 访问者
 *
 * @author zab
 * @date 2024/11/12 22:50
 */
public interface IVisitor {
    /**
     * 访问sim数据
     */
    void visit(SimData data);

    /**
     * 访问用户数据
     */
    void visit(UserBaseData data);
}
