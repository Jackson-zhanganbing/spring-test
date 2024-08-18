package com.zab.springboot.aop;

import java.util.Date;

/**
 * agent
 *
 * @author zab
 * @date 2024/8/11 12:38
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

