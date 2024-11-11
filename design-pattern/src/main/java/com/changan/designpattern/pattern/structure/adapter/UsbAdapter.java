package com.changan.designpattern.pattern.structure.adapter;
/**
 * 车辆点烟器的usb转换器
 *
 * @author zab
 * @date 2024/11/11 22:18
 */
public class UsbAdapter implements IUsb{
    private ICigaretteLighter cigaretteLighter;

    public UsbAdapter(ICigaretteLighter cigaretteLighter) {
        this.cigaretteLighter = cigaretteLighter;
    }

    @Override
    public void connect() {
        cigaretteLighter.supplyPower();
        System.out.println("点烟器接口 转换为 USB接口");
    }
}
