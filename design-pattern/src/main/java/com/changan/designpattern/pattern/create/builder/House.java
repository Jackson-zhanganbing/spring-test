package com.changan.designpattern.pattern.create.builder;

public class House {
    private String walls;
    private String roof;
    private String doors;

    public void setWalls(String walls) {
        this.walls = walls;
    }

    public void setRoof(String roof) {
        this.roof = roof;
    }

    public void setDoors(String doors) {
        this.doors = doors;
    }

    @Override
    public String toString() {
        return "House with " + walls + ", " + roof + " roof, and " + doors + " doors.";
    }
}
