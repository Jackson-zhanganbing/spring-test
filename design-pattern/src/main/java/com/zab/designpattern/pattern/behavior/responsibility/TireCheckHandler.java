package com.zab.designpattern.pattern.behavior.responsibility;

/**
 * 胎压检测
 *
 * @author zab
 * @date 2024/11/12 22:09
 */
public class TireCheckHandler implements CarCheckHandler{
    private CarCheckHandler nextHandler;

    @Override
    public void setNextHandler(CarCheckHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    @Override
    public void handleRequest(Car car) {
        if (car.getTirePressure() < 2.0) {
            System.out.println("轮胎压力低，请检查轮胎！");
        } else {
            System.out.println("轮胎正常，进行下一项。");
            if (nextHandler != null) {
                nextHandler.handleRequest(car);
            }

        }
    }
}
