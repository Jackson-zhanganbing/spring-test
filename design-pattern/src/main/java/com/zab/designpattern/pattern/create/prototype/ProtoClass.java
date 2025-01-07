package com.zab.designpattern.pattern.create.prototype;

/**
 * 原型模式
 *
 * @author anbing.zhang
 * @date 2024/11/8 11:24
 */
public class ProtoClass implements Prototype{

    public ProtoClass(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    private Long id;

    private String name;

    /**
     * 克隆自己
     */
    @Override
    public Prototype cloneProtoType() {
        return new ProtoClass(this.id, this.name);
    }
}
