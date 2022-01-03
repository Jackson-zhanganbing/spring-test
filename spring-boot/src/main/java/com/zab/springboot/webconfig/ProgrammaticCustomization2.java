package com.zab.springboot.webconfig;

import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.context.annotation.Configuration;

import java.time.Duration;

/**
 * 程序化定制容器配置，专门针对tomcat
 *
 * @author zab
 * @date 2021-12-10 22:01
 */
@Configuration
public class ProgrammaticCustomization2 implements WebServerFactoryCustomizer<TomcatServletWebServerFactory> {


    @Override
    public void customize(TomcatServletWebServerFactory server) {
        server.addConnectorCustomizers((connector) -> connector.setAsyncTimeout(Duration.ofSeconds(20).toMillis()));
    }
}
