package com.zab.springboot.corefeature;

import com.zab.springboot.common.async.taskexecute.AsyncTaskExecutor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
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
@Slf4j
@Order(2)
public class MyApplicationRunner implements ApplicationRunner {

    @Override
    public void run(ApplicationArguments args) throws Exception {
        log.info("程序启动了，这是程序启动后的一次代码初始化操作1");
        new Thread(AsyncTaskExecutor.getInstance()).run();
    }
}
