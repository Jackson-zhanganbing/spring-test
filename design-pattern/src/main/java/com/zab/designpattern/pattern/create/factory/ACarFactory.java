package com.zab.designpattern.pattern.create.factory;

/**
 * A类型Car工厂
 *
 * @author zab
 * @date 2024/11/9 11:40
 */
public class ACarFactory extends CarFactory{
    @Override
    public ICar createProduct() {
        return new ACar("CA", "123");
    }
}
