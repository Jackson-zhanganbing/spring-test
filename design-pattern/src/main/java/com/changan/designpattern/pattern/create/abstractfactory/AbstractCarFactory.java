package com.changan.designpattern.pattern.create.abstractfactory;


/**
 * 工厂模式
 * 特点：符合开闭原则，不修改现有代码情况下创建新的产品
 * 但是，每个产品都得有个工厂，增加了复杂性
 *
 * @author zab
 * @date 2024/11/9 11:40
 */
public interface AbstractCarFactory {
    ICarA productACar();
    ICarB productBCar();
}
