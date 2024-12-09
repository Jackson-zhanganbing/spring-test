package com.changan.designpattern.pattern.create.builder;

public class HouseDirector {
    private HouseBuilder builder;

    public HouseDirector(HouseBuilder builder) {
        this.builder = builder;
    }

    public void constructHouse() {
        builder.buildWalls();
        builder.buildRoof();
        builder.buildDoors();
    }
}
