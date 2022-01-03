package com.sms.starter.config;

import com.sms.starter.service.SmsService;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * description
 *
 * @author zab
 * @date 2021-12-08 22:54
 */
@Configuration
@EnableConfigurationProperties(SmsProperties.class)
public class SmsAutoConfiguration {
    @Bean
    public SmsService getBean(SmsProperties smsProperties){
        SmsService smsService = new SmsService(smsProperties);
        return smsService;
    }

    @Bean
    public RestTemplate restTemplate( ) {
        return new RestTemplate();
    }

}