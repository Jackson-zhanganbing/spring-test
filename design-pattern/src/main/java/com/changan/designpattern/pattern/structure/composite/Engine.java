package com.changan.designpattern.pattern.structure.composite;

public class Engine implements ICarComponent {
    @Override
    public void showDetails() {
        System.out.println("Engine: 2.0L Turbocharged");
    }
}
