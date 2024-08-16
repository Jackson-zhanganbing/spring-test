package com.zab.practice.instrument;

import java.util.Date;

/**
 * 业务类，要被修改的类
 *
 * @author zab
 * @date 2024/8/16 06:50
 */
public class BusinessClass {

    public void businessMethod() {
        System.out.println("businessMethod code: " + new Date());
    }


    public static void main(String[] args) {
        for (int i = 0; i < 10000; i++) {
            new BusinessClass().businessMethod();
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {

            }
        }
    }
}
