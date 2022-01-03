package com.zab.springboot.aop.proxy;

/**
 * 需要增强的类实现
 *
 * @author zab
 * @date 2021-12-02 22:41
 */
public class Worker implements IWorker{
    @Override
    public void work(){
        System.out.println("working============");
    }
}
