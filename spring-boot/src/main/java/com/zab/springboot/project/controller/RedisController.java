package com.zab.springboot.project.controller;

import com.zab.springboot.common.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * redis
 *
 * @author zab
 * @date 2021/12/13 11:01 PM
 */
@RestController
@RequestMapping("/api")
public class RedisController {

    @Autowired
    private RedisTemplate<String,String> redisTemplate;

    @RequestMapping("/redis/set")
    public ResponseVo<Boolean> set(String key, String value){
        redisTemplate.opsForValue().set(key, value);
        return ResponseVo.<Boolean>success(true);
    }
    @RequestMapping("/redis/get")
    public ResponseVo<String> get(String key){
        String s = redisTemplate.opsForValue().get(key);
        return ResponseVo.<String>success(s);
    }
}
