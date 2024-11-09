package com.changan.designpattern.pattern.create.builder;

/**
 * 建造者模式
 *
 * @author anbing.zhang
 * @date 2024/11/8 11:32
 */
public class BuilderClass {

    private Long id;

    private String name;

    public BuilderClass(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public static Builder builder(){
        return new Builder();
    }

    public BuilderClass() {
    }

    public static class Builder{

        private Long id;

        private String name;

        public Builder id(Long id){
            this.id = id;
            return this;
        }
        public Builder name(String name){
            this.name = name;
            return this;
        }

        public BuilderClass build(){
            return new BuilderClass(this.id, this.name);
        }


    }
}
