package com.zab.agent;

import java.io.Serializable;
import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.Instrumentation;
import java.security.ProtectionDomain;
import java.util.UUID;

import org.apache.logging.log4j.core.Filter;
import org.apache.logging.log4j.core.Layout;
import org.apache.logging.log4j.core.LogEvent;
import org.apache.logging.log4j.core.appender.AbstractAppender;
import org.apache.logging.log4j.core.config.Property;
import org.apache.logging.log4j.core.impl.Log4jLogEvent;
import org.apache.logging.log4j.message.Message;
import org.objectweb.asm.*;
import org.slf4j.MDC;

public class Log4j2TraceIdAgent {

    public static void premain(String agentArgs, Instrumentation inst) {
        inst.addTransformer(new LogTransformer());
    }

    static class LogTransformer implements ClassFileTransformer {

        @Override
        public byte[] transform(ClassLoader loader, String className, Class<?> classBeingRedefined,
                                ProtectionDomain protectionDomain, byte[] classfileBuffer) {
            System.out.println("=================transform====================");
            if (className.equals("org.apache.logging.log4j.core.appender.AbstractAppender")) {
                return modifyAbstractAppenderClass(classfileBuffer);
            }
            return classfileBuffer;
        }

        private byte[] modifyAbstractAppenderClass(byte[] classfileBuffer) {
            ClassWriter classWriter = new ClassWriter(0);
            ClassReader classReader = new ClassReader(classfileBuffer);
            classReader.accept(new ClassVisitor(Opcodes.ASM9) {
                @Override
                public MethodVisitor visitMethod(int access, String name, String descriptor, String signature,
                                                 String[] exceptions) {
                    MethodVisitor mv = super.visitMethod(access, name, descriptor, signature, exceptions);
                    if (name.equals("append") && descriptor.equals("(Lorg/apache/logging/log4j/core/LogEvent;)V")) {
                        return new MethodVisitor(Opcodes.ASM9, mv) {
                            @Override
                            public void visitCode() {
                                // 生成一个 UUID 作为 traceId
                                mv.visitLdcInsn(UUID.randomUUID().toString());
                                // 将 traceId 添加到日志事件的上下文
                                mv.visitMethodInsn(Opcodes.INVOKESTATIC,
                                        "org/apache/logging/log4j/core/LogEvent",
                                        "getContextData",
                                        "()Lorg/apache/logging/log4j/core/ContextData;",
                                        false);
                                mv.visitMethodInsn(Opcodes.INVOKEINTERFACE,
                                        "org/apache/logging/log4j/core/ContextData",
                                        "putValue",
                                        "(Ljava/lang/String;Ljava/lang/Object;)V",
                                        true);
                                super.visitCode();
                            }
                        };
                    }
                    return mv;
                }
            }, 0);
            return classWriter.toByteArray();
        }
    }

    static class CustomAppender extends AbstractAppender {

        public CustomAppender(String name, Layout<? extends Serializable> layout, Filter filter,
                              boolean ignoreExceptions, Property[] properties) {
            super(name, filter, layout, ignoreExceptions, properties);
        }

        @Override
        public void append(LogEvent event) {
            // 从日志事件的上下文中获取 traceId
            String traceId = (String) event.getContextData().getValue("traceId");
            // 将 traceId 添加到日志消息
            Message message = ((Log4jLogEvent)event).getMessage();
            String formattedMessage = traceId + " - " + message.getFormattedMessage();
            System.out.println("======"+formattedMessage);
            MDC.put("traceId", formattedMessage);

            String traceId1 = (String) event.getContextData().getValue("traceId");

            System.out.println("======"+traceId1);
        }
    }
}