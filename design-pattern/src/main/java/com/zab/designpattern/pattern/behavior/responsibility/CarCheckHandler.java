package com.zab.designpattern.pattern.behavior.responsibility;


/**
 * 车辆检查处理器
 *
 * @author zab
 * @date 2024/11/12 22:05
 */
public interface CarCheckHandler {
    void setNextHandler(CarCheckHandler nextHandler);
    void handleRequest(Car car);
}
