package com.zab.designpattern.pattern.behavior.visitor;

/**
 * 车辆基础数据
 *
 * @author zab
 * @date 2024/11/12 22:48
 */
public interface ICarBaseData {
    void accept(IVisitor visitor);
}
