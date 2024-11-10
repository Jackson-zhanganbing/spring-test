package com.changan.designpattern.pattern.structure.proxy;

/**
 * 代理驾驶员
 *
 * @author zab
 * @date 2024/11/10 11:13
 */
public class ProxyDriver implements Driver{

    private ConcreteDriver concreteDriver;

    private void drinkCheck(){
        System.out.println("代驾没喝酒，可以通过酒精检测");
    }

    @Override
    public void goHome() {
        if(concreteDriver == null){
            concreteDriver = new ConcreteDriver();
        }
        drinkCheck();
        concreteDriver.goHome();
    }
}
