package com.zab.springboot.webconfig;

import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.context.annotation.Configuration;

/**
 * 程序化定制容器配置
 *
 * @author zab
 * @date 2021-12-10 22:01
 */
@Configuration
public class ProgrammaticCustomization1 implements WebServerFactoryCustomizer<ConfigurableServletWebServerFactory> {


    @Override
    public void customize(ConfigurableServletWebServerFactory server) {
        server.setPort(9000);
    }
}
