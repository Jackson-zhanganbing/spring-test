package com.changan.designpattern.pattern.structure.adapter;

/**
 * usb 设备
 *
 * @author zab
 * @date 2024/11/11 22:15
 */
public class UsbDevice implements IUsb{
    @Override
    public void connect() {
        System.out.println("usb 设备 连接");
    }
}
