package com.zab.springboot.webconfig;

import com.zab.springboot.aop.interceptor.MyInterceptor;
import com.zab.springboot.aop.interceptor.TokenInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
/**
 * 拦截器配置
 *
 * @author zab
 * @date 2021/12/14 10:00 PM
 */

@Configuration
public class MyWebConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new TokenInterceptor());
        registry.addInterceptor(new MyInterceptor());
    }
}
