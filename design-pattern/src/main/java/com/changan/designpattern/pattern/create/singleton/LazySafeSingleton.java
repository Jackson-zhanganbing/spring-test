package com.changan.designpattern.pattern.create.singleton;

/**
 * 懒汉式单例（线程安全）
 * 特点：在第一次使用时懒加载，通过同步方法来实现线程安全，但会影响性能。
 *
 * @author zab
 * @date 2024/11/9 10:48
 */
public class LazySafeSingleton {
    private static LazySafeSingleton instance;

    private LazySafeSingleton() {
    }

    public static synchronized LazySafeSingleton getInstance() {
        if (instance == null) {
            instance = new LazySafeSingleton();
        }
        return instance;
    }
}
