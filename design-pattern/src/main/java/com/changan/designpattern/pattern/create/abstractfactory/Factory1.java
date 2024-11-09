package com.changan.designpattern.pattern.create.abstractfactory;

public class Factory1 implements AbstractCarFactory {
    @Override
    public ICarA productACar() {
        return new ACar1("CA1", "123");
    }

    @Override
    public ICarB productBCar() {
        return new BCar1("SL1", "234");
    }
}
