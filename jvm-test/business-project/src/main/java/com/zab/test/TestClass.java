package com.zab.test;

public class TestClass {
    public static void main(String[] args) {
        for (int i = 0; i < 10000; i++) {
            System.out.println(i);

            try{
                Thread.sleep(1000);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
