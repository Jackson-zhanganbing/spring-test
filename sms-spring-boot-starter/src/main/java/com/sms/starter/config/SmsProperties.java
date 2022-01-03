package com.sms.starter.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 主项目集成该starter后，就可以自动配置这些属性
 *
 * @author zab
 * @date 2021-12-08 22:56
 */
@Data
@ConfigurationProperties(prefix = "sms-config")
public class SmsProperties {
    private String appid;
    private String accountSid;
    private String authToken;
}