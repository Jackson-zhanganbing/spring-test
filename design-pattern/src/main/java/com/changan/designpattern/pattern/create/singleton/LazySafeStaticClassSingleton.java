package com.changan.designpattern.pattern.create.singleton;

/**
 * 静态内部类单例
 * 特点：利用静态内部类的加载机制，既实现懒加载又线程安全。
 *
 * @author zab
 * @date 2024/11/9 10:48
 */
public class LazySafeStaticClassSingleton {
    private LazySafeStaticClassSingleton() {}

    private static class Holder {
        private static final LazySafeStaticClassSingleton INSTANCE = new LazySafeStaticClassSingleton();
    }

    public static LazySafeStaticClassSingleton getInstance() {
        return Holder.INSTANCE;
    }
}
