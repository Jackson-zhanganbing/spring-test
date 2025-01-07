package com.zab.designpattern.pattern.behavior.observer;
/**
 * 观察者接口
 *
 * @author zab
 * @date 2024/11/12 20:57
 */
public interface IObserver {

    /**
     * 观察者接收消息
     *
     * @param temperature 气温
     * @param weather 天气，比如：阴
     */
    void receive(double temperature, String weather);
}
