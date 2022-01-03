package com.zab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * spring mvc 最小配置
 *
 * @author zab
 * @date 2021-11-19 23:33
 */
@RestController
@RequestMapping("/api")
public class HelloController {

    @Autowired
    private Hello hello;

    @GetMapping("/hello")
    public String hello(){

        return hello.toString();
    }
}
