package com.zab.springboot.enableannotation;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;
/**
 * description
 *
 * @author zab
 * @date 2022/5/9 22:20
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(LoginFilterWebConfig.class)
public @interface EnableLogin {

}