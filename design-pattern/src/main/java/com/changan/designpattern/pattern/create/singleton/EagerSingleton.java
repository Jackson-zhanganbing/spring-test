package com.changan.designpattern.pattern.create.singleton;

/**
 * 饿汉式单例模式
 * 特点：在类加载时就初始化实例，确保线程安全但可能会造成资源浪费。
 *
 * @author zab
 * @date 2024/11/9 10:46
 */
public class EagerSingleton {
    private static final EagerSingleton INSTANCE = new EagerSingleton();

    private EagerSingleton() {
    }

    public static EagerSingleton getInstance() {
        return INSTANCE;
    }
}
