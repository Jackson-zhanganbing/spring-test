package com.zab.springboot.properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import javax.annotation.PostConstruct;

/**
 * 属性获取测试，使用environment
 *
 * @author zab
 * @date 2021-11-21 21:11
 */
@Configuration
public class PropertiesTest3 {
    /**
     * 方式三，environment
     */
    public String test3;
    @Autowired
    private Environment environment;

    @PostConstruct
    private void init(){
        this.test3 = environment.getProperty("test3");
    }

}
