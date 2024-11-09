package com.changan.designpattern.pattern.create.abstractfactory;

public class Factory2 implements AbstractCarFactory {
    @Override
    public ICarA productACar() {
        return new ACar2("CA2", "1233");
    }

    @Override
    public ICarB productBCar() {
        return new BCar2("SL2", "2344");
    }
}
