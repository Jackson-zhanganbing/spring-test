package com.changan.designpattern.pattern.create.abstractfactory;


/**
 * 抽象工厂模式
 * 特点：符合开闭原则，抽象工厂模式扩展了工厂方法，它一次性创建多个相关的产品，而不仅限于一个产品
 * 但是，每个产品都得有个工厂，增加了复杂性
 *
 * @author zab
 * @date 2024/11/9 11:40
 */
public interface AbstractPancakeFactory {
    /**
     * 生产煎饼
     */
    IPancake producePancake();

    /**
     * 生产肉松
     */
    IMeatFloss produceMeatFloss();
}
