package com.zab.designpattern.pattern.structure.adapter;

/**
 * 适配器模式
 *
 * @author zab
 * @date 2024/11/11 22:20
 */
public class Test {
    public static void main(String[] args) {
        //usb适配器，传入点烟器，连接时就可以转换为usb
        UsbAdapter usbAdapter = new UsbAdapter(new CigaretteLighterImpl());
        usbAdapter.connect();
    }
}
