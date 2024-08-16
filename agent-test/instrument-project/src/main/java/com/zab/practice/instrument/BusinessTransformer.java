package com.zab.practice.instrument;

import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;

import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.security.ProtectionDomain;

/**
 * 类转换定义
 *
 * @author zab
 * @date 2024/8/16 06:51
 */
public class BusinessTransformer implements ClassFileTransformer {
    @Override
    public byte[] transform(ClassLoader loader,
                            String className,
                            Class<?> classBeingRedefined,
                            ProtectionDomain protectionDomain,
                            byte[] classfileBuffer)
            throws IllegalClassFormatException {

        System.out.println("start transform: " + className + " " + Thread.currentThread().getName());

        //这里只重新定义BusinessClass类，采用了javassist框架来完成类的重定义，也可采用其他二进制框架，比如ASM
        if (className.equalsIgnoreCase("com/zab/practice/instrument/BusinessClass")) {

            try {
                ClassPool classPool = ClassPool.getDefault();

                try {
                    CtClass ctClass = classPool.get(className.replaceAll("/", "."));
                    CtMethod ctMethod = ctClass.getDeclaredMethod("businessMethod");
                    if (!ctMethod.isEmpty()) {
                        ctMethod.setBody("" +
                                "{" +
                                "System.out.println(\"instrument api success\");" +
                                "}");
                    }
                    return ctClass.toBytecode();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } catch (Throwable e) {
                e.printStackTrace();
            }
        }

        return classfileBuffer;
    }
}
