package com.zab.practice.instrument;

import java.lang.instrument.Instrumentation;

/**
 * agent
 *
 * @author zab
 * @date 2024/8/16 06:51
 */
public class InstrumentAgent {
    public static void agentmain(String agentArgs, Instrumentation inst) {
        try {
            System.out.println("Agent Main Start");

            //创建一个ClassFileTransformer对象，在这个对象的transform方法中完成真正的字节码替换
            BusinessTransformer businessTransformer = new BusinessTransformer();
            inst.addTransformer(businessTransformer, true);

            //触发BusinessClass的二进制更新，执行该代码后会执行ClassFileTransformer对象的transform方法
            inst.retransformClasses(Class.forName("com.zab.practice.instrument.BusinessClass"));


            //移除（如果不移除，多次执行attach,那么transform方法会执行多次，没有意义）
            inst.removeTransformer(businessTransformer);
            System.out.println("Agent Main End: " + Thread.currentThread().getName());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
