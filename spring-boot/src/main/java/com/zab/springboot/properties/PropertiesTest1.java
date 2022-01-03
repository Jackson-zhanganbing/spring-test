package com.zab.springboot.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
/**
 * 普通@Value，默认读取application
 *
 * @author zab
 * @date 2021-11-21 21:11
 */
@Configuration
public class PropertiesTest1 {
    /**
     * 方式一：@Value
     */
    @Value("${test1}")
    public String test1;

}
