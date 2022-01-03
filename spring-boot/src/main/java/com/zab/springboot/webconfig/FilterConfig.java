package com.zab.springboot.webconfig;

import com.zab.springboot.aop.filter.LoginFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
/**
 * 过滤器配置
 *
 * @author zab
 * @date 2021/12/14 10:21 PM
 */
@Configuration
public class FilterConfig {

    @Bean
    public FilterRegistrationBean loginFilter(){
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new LoginFilter());
        registration.addUrlPatterns("/*");
        registration.setName("LoginFilter");
        registration.setOrder(1);
        return registration;
    }
}
