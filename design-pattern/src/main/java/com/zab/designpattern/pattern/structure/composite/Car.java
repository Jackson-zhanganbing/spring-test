package com.zab.designpattern.pattern.structure.composite;

import java.util.ArrayList;
import java.util.List;

public class Car implements ICarComponent {

    private List<ICarComponent> components = new ArrayList();

    public void addComponent(ICarComponent component) {
        components.add(component);
    }

    public void removeComponent(ICarComponent component) {
        components.remove(component);
    }

    @Override
    public void showDetails() {
        System.out.println("Car Components:");
        for (ICarComponent component : components) {
            component.showDetails();
        }
    }
}
