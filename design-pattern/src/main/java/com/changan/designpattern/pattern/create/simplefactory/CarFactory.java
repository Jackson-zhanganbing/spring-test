package com.changan.designpattern.pattern.create.simplefactory;

/**
 * 简单工厂
 * 特点：可以根据不同类型创建产品，但是新增产品类型，会修改工厂代码，不符合：开闭原则
 *
 * @author zab
 * @date 2024/11/9 11:40
 */
public class CarFactory {
    public static ICar createProduct(String type) {
        if ("A".equals(type)) {
            return new ACar("CA", "123");
        } else if ("B".equals(type)) {
            return new BCar("SL", "321");
        }
        return null;
    }
}
