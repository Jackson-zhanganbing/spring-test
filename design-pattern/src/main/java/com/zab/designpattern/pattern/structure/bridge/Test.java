package com.zab.designpattern.pattern.structure.bridge;

/**
 * 桥接模式测试类
 *
 * @author zab
 * @date 2024/11/10 12:23
 */
public class Test {
    public static void main(String[] args) {
        ElectricEngine electricEngine = new ElectricEngine();
        HybridEngine hybridEngine = new HybridEngine();

        SUV electricSuv = new SUV(electricEngine);
        SUV hybridSuv = new SUV(hybridEngine);

        Sedan electricSedan = new Sedan(electricEngine);
        Sedan hybridSedan = new Sedan(hybridEngine);

        electricSuv.run();
        hybridSuv.run();
        electricSedan.run();
        hybridSedan.run();
    }
}
