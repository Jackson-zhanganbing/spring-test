package com.zab.springboot.corefeature;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * If you need to run some specific code once the SpringApplication has started,
 * you can implement the ApplicationRunner or CommandLineRunner interfaces.
 *
 * @author zab
 * @date 2021-12-04 00:41
 */
@Component
@Order(1)
public class MyCommandLineRunner implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        System.out.println("程序启动了，这是程序启动后的一次代码初始化操作2");
    }
}
