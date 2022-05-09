package com.zab.springboot.enableannotation;

import com.zab.springboot.aop.filter.LoginFilter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.context.annotation.Bean;
/**
 * 注册登录过滤器方式
 * 1、AnnotationLoginFilter方式
 * 2、FilterConfig方式
 * 3、EnableLogin方式
 *
 * @author zab
 * @date 2022/5/9 22:22
 */
@ConditionalOnWebApplication
public class LoginFilterWebConfig {
    @Bean
    public LoginFilter timeFilter() {
        return new LoginFilter();
    }
}
