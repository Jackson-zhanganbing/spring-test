package com.zab.practice.instrument;

import com.sun.tools.attach.VirtualMachine;

/**
 * 测试类，执行修改调用的类
 *
 * @author zab
 * @date 2024/8/16 06:50
 */
public class AttachMain {
    public static void main(String[] args) {
        /*List<VirtualMachineDescriptor> vms = VirtualMachine.list();
        for (VirtualMachineDescriptor vm : vms) {
            System.out.println(vm.displayName());
        }*/
        try {
            VirtualMachine attach = VirtualMachine.attach("8801");
            attach.loadAgent("/Users/zhanganbing/IdeaProjects/spring-test/agent-test/instrument-project/target/instrument-project-1.0-SNAPSHOT-jar-with-dependencies.jar");
            Thread.sleep(1000000);
            attach.detach();
            System.out.println("detached");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
