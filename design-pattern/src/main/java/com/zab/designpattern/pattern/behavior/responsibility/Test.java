package com.zab.designpattern.pattern.behavior.responsibility;

/**
 * 责任链模式测试
 *
 * @author zab
 * @date 2024/11/12 22:09
 */
public class Test {
    public static void main(String[] args) {
        Car car = new Car(99, 1.9);
        CarCheckHandler checkChain = getCheckChain();

        checkChain.handleRequest(car);

    }

    private static CarCheckHandler getCheckChain(){
        OilCheckHandler oilCheckHandler = new OilCheckHandler();
        TireCheckHandler tireCheckHandler = new TireCheckHandler();
        oilCheckHandler.setNextHandler(tireCheckHandler);
        return oilCheckHandler;
    }
}
