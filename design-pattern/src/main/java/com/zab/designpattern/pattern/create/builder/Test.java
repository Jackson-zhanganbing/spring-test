package com.zab.designpattern.pattern.create.builder;

/**
 * 建造者测试
 *
 * @author anbing.zhang
 * @date 2024/11/8 13:19
 */
public class Test {
    public static void main(String[] args) {
        HouseBuilder builder = new WoodenHouseBuilder();
        HouseDirector director = new HouseDirector(builder);

        director.constructHouse();

        House house = builder.getResult();
        System.out.println(house);
    }
}
