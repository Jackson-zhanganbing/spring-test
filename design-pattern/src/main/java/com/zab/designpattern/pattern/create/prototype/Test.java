package com.zab.designpattern.pattern.create.prototype;

/**
 * 测试
 *
 * @author anbing.zhang
 * @date 2024/11/8 11:29
 */
public class Test {
    public static void main(String[] args) {
        ProtoClass protoClass = new ProtoClass(666L, "changan");

        //使用原型模式，创建对象
        ProtoClass prototype = (ProtoClass) protoClass.cloneProtoType();
        System.out.println(protoClass);
        System.out.println(prototype);
    }
}
