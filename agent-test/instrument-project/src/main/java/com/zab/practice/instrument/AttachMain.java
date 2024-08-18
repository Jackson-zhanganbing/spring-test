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
        try {
            String property = System.getProperty("user.dir");
            VirtualMachine attach = VirtualMachine.attach("17660");
            attach.loadAgent(property + "/agent-test/instrument-project/target/instrument-project-1.0-SNAPSHOT-jar-with-dependencies.jar");
            Thread.sleep(1000000);
            attach.detach();
            System.out.println("detached");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
