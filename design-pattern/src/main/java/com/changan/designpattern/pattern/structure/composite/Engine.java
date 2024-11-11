package com.changan.designpattern.pattern.structure.composite;

public class Engine implements CarComponent{
    @Override
    public void showDetails() {
        System.out.println("Engine: 2.0L Turbocharged");
    }
}
