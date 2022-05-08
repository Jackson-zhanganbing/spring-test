package com.zab.springboot.initbean;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * 利用PostConstruct初始化bean
 *
 * @author zab
 * @date 2022/5/8 21:26
 */
@Component
@Slf4j
public class PostConstructInitTest {

    @PostConstruct
    public void init() {
        log.info("PostConstructInitTest========>init");
    }
}
