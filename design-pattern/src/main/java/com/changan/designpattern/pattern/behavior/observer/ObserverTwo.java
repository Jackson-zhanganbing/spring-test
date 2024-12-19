package com.changan.designpattern.pattern.behavior.observer;

/**
 * 订阅者2
 *
 * @author zab
 * @date 2024/11/12 21:02
 */
public class ObserverTwo implements IObserver {
    @Override
    public void receive(double temperature, String weather) {
        System.out.println("订阅者2收到天气：今天气温：" + temperature + "度，天气： " + weather);
    }
}
