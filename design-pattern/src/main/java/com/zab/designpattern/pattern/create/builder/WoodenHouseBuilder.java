package com.zab.designpattern.pattern.create.builder;

public class WoodenHouseBuilder implements HouseBuilder {
    private House house;

    public WoodenHouseBuilder() {
        this.house = new House();
    }

    @Override
    public void buildWalls() {
        house.setWalls("wooden walls");
    }

    @Override
    public void buildRoof() {
        house.setRoof("wooden roof");
    }

    @Override
    public void buildDoors() {
        house.setDoors("2 wooden doors");
    }

    @Override
    public House getResult() {
        return house;
    }
}
