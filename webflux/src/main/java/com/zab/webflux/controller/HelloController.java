package com.zab.webflux.controller;

import com.zab.webflux.common.TestBean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Hooks;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.Date;

/**
 * webflux测试
 *
 * @author zab
 * @date 2021-12-11 23:15
 */
@RestController
@RequestMapping("/api")
public class HelloController {


    @GetMapping("/{name}")
    public Mono<TestBean> test1(@PathVariable String name) {
        Hooks.onOperatorDebug();
        TestBean zhangsan = TestBean.builder()
                .isBig(true).nowDate(new Date())
                .weight("150")
                .names(Arrays.asList(name)).build();

        return Mono.just(zhangsan);
    }

    @GetMapping("/test2")
    public Flux<TestBean> test2() {
        TestBean zhangsan = TestBean.builder()
                .isBig(true).nowDate(new Date())
                .weight("150")
                .names(Arrays.asList("lisi")).build();

        return Flux.just(zhangsan);
    }
}
