package com.zab.springboot.initbean;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * 实现InitializingBean接口，实现初始化
 * 调用顺序：PostConstruct > InitializingBean
 *
 * @author zab
 * @date 2022/5/8 21:28
 */
@Component
@Slf4j
public class InitializingBeanInitTest implements InitializingBean {

    @PostConstruct
    public void init() {
        log.info("PostConstruct========>init");
    }
    @Override
    public void afterPropertiesSet() throws Exception {
        log.info("InitializingBeanInitTest========>init");
    }
}
