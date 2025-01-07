package com.zab.designpattern.pattern.behavior.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * 具体的天气主题
 *
 * @author zab
 * @date 2024/11/12 21:01
 */
public class ConcreteWeatherSubject implements WeatherSubject {

    List<IObserver> observerList = new ArrayList<IObserver>();

    private double temperature;
    private String weather;

    @Override
    public void registerObserver(IObserver observer) {
        observerList.add(observer);
    }

    @Override
    public void removeObserver(IObserver observer) {
        observerList.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (IObserver iObserver : observerList) {
            iObserver.receive(temperature, weather);
        }
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }
}
