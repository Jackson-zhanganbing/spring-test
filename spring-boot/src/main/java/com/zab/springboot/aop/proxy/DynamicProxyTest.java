package com.zab.springboot.aop.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
/**
 * jdk动态代理测试
 *
 * @author zab
 * @date 2021-12-02 22:47
 */
public class DynamicProxyTest {
    public static void main(String[] args) {
        Advice advice = new Advice();

        Worker worker = new Worker();

        IWorker proxyWorker = (IWorker)Proxy.newProxyInstance(Worker.class.getClassLoader(), Worker.class.getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                advice.before();
                Object invoke = method.invoke(worker, args);
                advice.after();
                return invoke;
            }
        });

        IWorker proxyWorker1 = (IWorker)Proxy.newProxyInstance(Worker.class.getClassLoader(), Worker.class.getInterfaces(), (Object proxy, Method method, Object[] param)->{
            advice.before();
            Object invoke = method.invoke(worker, param);
            advice.after();
            return invoke;
        });

        proxyWorker1.work();
    }

}
