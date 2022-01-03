package com.zab.springboot.properties;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
/**
 * 引入别的配置文件，别的配置文件就可以不用Configuration注解标记
 *
 * @author zab
 * @date 2021-12-06 22:35
 */
@Configuration
@EnableConfigurationProperties(PropertiesTest5.class)
public class PropertiesConfig {
}
