package com.zab.springboot.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * 指定配置文件
 * 1、必须是不同的properties文件才有效，如果properties和yml的属性一样，不管指定哪个配置文件，都是读取的yml中的值
 * 2、不同的properties，相同的key可以通过指定不同的路径读取到不同的值
 *
 * @author zab
 * @date 2021-11-21 21:11
 */
@PropertySource(value = {"classpath:test2-1.properties"}, encoding = "utf-8")
@Configuration
public class PropertiesTest2 {
    /**
     * 方式二：指定配置文件
     */
    @Value("${test2}")
    public String test2;

}
