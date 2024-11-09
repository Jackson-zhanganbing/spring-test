package com.changan.designpattern.pattern.create.abstractfactory;

/**
 * A汽车1
 *
 * @author zab
 * @date 2024/11/9 11:34
 */
public class ACar1 implements ICarA {
    private String brand;
    private String vin;

    public ACar1(String brand, String vin) {
        this.brand = brand;
        this.vin = vin;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    @Override
    public void run() {
        System.out.println(brand + vin + "跑起来了");
    }
}
