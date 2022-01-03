package com.zab.springboot.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * 属性获取测试，通过ConfigurationProperties，可以获取复杂属性的不同子项
 * 必须添加getter、setter，说明这种赋值没用反射？
 *
 * @author zab
 * @date 2021-11-21 21:11
 */
@ConfigurationProperties(prefix = "test4")
@Configuration
public class PropertiesTest4 {
    /**
     * 方式四
     */
    public String four1;
    public String four2;

    public String getFour1() {
        return four1;
    }

    public void setFour1(String four1) {
        this.four1 = four1;
    }

    public String getFour2() {
        return four2;
    }

    public void setFour2(String four2) {
        this.four2 = four2;
    }

}
