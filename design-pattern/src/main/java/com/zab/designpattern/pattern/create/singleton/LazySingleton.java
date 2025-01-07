package com.zab.designpattern.pattern.create.singleton;

/**
 * 懒汉式单例（线程不安全）
 * 特点：在第一次使用时懒加载，但不是线程安全的。
 *
 * @author zab
 * @date 2024/11/9 10:48
 */
public class LazySingleton {
    private static LazySingleton instance;

    private LazySingleton() {
    }

    public static LazySingleton getInstance() {
        if (instance == null) {
            instance = new LazySingleton();
        }
        return instance;
    }
}
