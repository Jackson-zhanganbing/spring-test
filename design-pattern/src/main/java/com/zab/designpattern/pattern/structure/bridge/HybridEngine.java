package com.zab.designpattern.pattern.structure.bridge;

/**
 * 混合引擎
 *
 * @author zab
 * @date 2024/11/10 12:17
 */
public class HybridEngine implements IEngine{

    @Override
    public void desc() {
        System.out.println("混动引擎");
    }
}
