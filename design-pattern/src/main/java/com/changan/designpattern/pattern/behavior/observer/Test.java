package com.changan.designpattern.pattern.behavior.observer;

/**
 * 观察者模式测试
 *
 * @author zab
 * @date 2024/11/12 21:06
 */
public class Test {
    public static void main(String[] args) {
        PersonOne personOne = new PersonOne();
        PersonTwo personTwo = new PersonTwo();

        //构造天气预报
        ConcreteWeatherSubject concreteWeatherSubject = new ConcreteWeatherSubject();

        //订阅者订阅
        concreteWeatherSubject.registerObserver(personOne);
        concreteWeatherSubject.registerObserver(personTwo);

        //天气预报结果
        concreteWeatherSubject.setWeather("晴");
        concreteWeatherSubject.setTemperature(25.2);
        //通知订阅者
        concreteWeatherSubject.notifyObservers();

        //订阅者1取消
        concreteWeatherSubject.removeObserver(personOne);
        System.out.println("=============订阅者取消==============");

        //天气预报结果
        concreteWeatherSubject.setWeather("大雨");
        concreteWeatherSubject.setTemperature(21.2);
        //通知订阅者
        concreteWeatherSubject.notifyObservers();

    }
}
