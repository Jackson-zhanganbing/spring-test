package com.changan.designpattern.pattern.behavior.responsibility;

/**
 * 油量检查
 *
 * @author zab
 * @date 2024/11/12 22:07
 */
public class OilCheckHandler implements CarCheckHandler{
    private CarCheckHandler nextHandler;

    @Override
    public void setNextHandler(CarCheckHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    @Override
    public void handleRequest(Car car) {
        if (car.getOilLevel() < 10) {
            System.out.println("油量低，请加油！");
        } else {
            System.out.println("油量正常，继续检查。");
            if (nextHandler != null) {
                nextHandler.handleRequest(car);
            }
        }
    }
}
