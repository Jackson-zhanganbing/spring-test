package com.zab.lifecycle.annotation.thirdbean;

import com.zab.lifecycle.annotation.AnnotationTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.time.ZoneId;
/**
 * 第三方bean的注入方式，自有bean可通过xml和注解形式
 *
 * @author zab
 * @date 2021-11-19 22:37
 */
@Component
public class ThirdBeanTest {

    @Autowired
    private ZoneId zoneId;

    /**
     * 如果这里注入第三方bean不加primary，因为有两个ZoneId定义，注入的时候会报错
     * No qualifying bean of type 'java.time.ZoneId' available:
     */
    @Bean
    @Primary
    public ZoneId getThirdBean(){
        return ZoneId.of("Z");
    }

    @Bean("nameType1")
    public ZoneId getThirdBean1(){
        return ZoneId.of("Z");
    }
    @Bean
    @Qualifier("nameType2")
    public ZoneId getThirdBean2(){
        return ZoneId.of("UTC+08:00");
    }

    public static void main(String[] args) {
        ApplicationContext factory = new AnnotationConfigApplicationContext(AnnotationTest.class);
        ZoneId zoneId = factory.getBean(ZoneId.class);
        System.out.println(zoneId);
    }
}
