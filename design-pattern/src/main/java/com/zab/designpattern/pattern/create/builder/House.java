package com.zab.designpattern.pattern.create.builder;

public class House {
    //墙
    private String walls;
    //屋顶
    private String roof;
    //门
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
