package com.changan.designpattern.pattern.structure.composite;

public class Tire implements ICarComponent {
    @Override
    public void showDetails() {
        System.out.println("Tire: 225/45R17");
    }
}
