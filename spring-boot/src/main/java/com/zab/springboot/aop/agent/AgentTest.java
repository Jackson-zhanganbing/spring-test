package com.zab.springboot.aop.agent;

import lombok.Data;

import java.util.Date;

/**
 * agent测试类，在该类中添加一个字段
 *
 * @author zab
 * @date 2024/8/11 12:38
 */
@Data
public class AgentTest {
    private String name;

    public void businessMethod() {
        System.out.println("businessMethod code: " + new Date());
    }


    public static void main(String[] args) {
        for (int i = 0; i < 10000; i++) {
            new AgentTest().businessMethod();
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {

            }
        }
    }
}
