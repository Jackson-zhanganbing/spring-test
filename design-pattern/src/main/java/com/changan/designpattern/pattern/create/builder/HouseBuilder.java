package com.changan.designpattern.pattern.create.builder;

public interface HouseBuilder {
    void buildWalls();
    void buildRoof();
    void buildDoors();
    House getResult();
}
