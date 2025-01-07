package com.zab.designpattern.pattern.behavior.observer;

/**
 * 观察者主题
 *
 * @author zab
 * @date 2024/11/12 20:51
 */
public interface WeatherSubject {
    /**
     * 注册观察者
     *
     * @param observer 观察者
     */
    void registerObserver(IObserver observer);
    /**
     * 移除观察者
     *
     * @param observer 观察者
     */
    void removeObserver(IObserver observer);
    /**
     * 通知观察者
     */
    void notifyObservers();
}
