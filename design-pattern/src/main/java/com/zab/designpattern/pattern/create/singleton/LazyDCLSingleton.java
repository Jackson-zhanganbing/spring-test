package com.zab.designpattern.pattern.create.singleton;

/**
 * 双重检查锁定（DCL: double check lock）单例
 * 特点：在第一次使用时懒加载，结合懒加载和同步，减小同步范围，提高效率
 *
 * @author zab
 * @date 2024/11/9 10:48
 */
public class LazyDCLSingleton {
    private static LazyDCLSingleton instance;

    private LazyDCLSingleton() {
    }

    public static LazyDCLSingleton getInstance() {
        if (instance == null) {
            synchronized (LazySingleton.class) {
                if (instance == null) {
                    instance = new LazyDCLSingleton();
                }
            }
        }
        return instance;
    }
}
