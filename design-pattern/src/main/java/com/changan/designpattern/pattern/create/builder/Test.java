package com.changan.designpattern.pattern.create.builder;

/**
 * 建造者测试
 *
 * @author anbing.zhang
 * @date 2024/11/8 13:19
 */
public class Test {
    public static void main(String[] args) {
        BuilderClass changan = BuilderClass.builder()
                .name("changan")
                .id(666L)
                .build();

    }
}
