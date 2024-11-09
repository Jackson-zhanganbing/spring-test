package com.zab.dynamic;

import java.io.FileInputStream;

public class Test {
    public static void main(String[] args) throws Exception{
        FileInputStream is = new FileInputStream("D:\\project\\spring-test\\target\\classes\\com\\zab\\test\\TestClass.class");
        byte[] b = new byte[is.available()];
        JavaClassExecuter.execute(b);

    }
}
