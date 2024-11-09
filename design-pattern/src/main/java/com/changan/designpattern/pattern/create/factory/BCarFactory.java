package com.changan.designpattern.pattern.create.factory;

/**
 * B类型Car工厂
 *
 * @author zab
 * @date 2024/11/9 11:40
 */
public class BCarFactory extends CarFactory{
    @Override
    public ICar createProduct() {
        return new ACar("SL", "123");
    }
}
