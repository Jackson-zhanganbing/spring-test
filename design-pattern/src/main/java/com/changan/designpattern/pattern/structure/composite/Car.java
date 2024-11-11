package com.changan.designpattern.pattern.structure.composite;

import java.util.ArrayList;
import java.util.List;

public class Car implements CarComponent {
    private List<CarComponent> components = new ArrayList();

    public void addComponent(CarComponent component) {
        components.add(component);
    }

    public void removeComponent(CarComponent component) {
        components.remove(component);
    }

    @Override
    public void showDetails() {
        System.out.println("Car Components:");
        for (CarComponent component : components) {
            component.showDetails();
        }
    }
}
