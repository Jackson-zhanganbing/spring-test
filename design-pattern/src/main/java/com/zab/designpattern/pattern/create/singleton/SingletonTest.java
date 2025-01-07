package com.zab.designpattern.pattern.create.singleton;

import java.lang.reflect.Constructor;
/**
 * 示例演示了，通过反射尝试创建枚举会报：
 * java.lang.IllegalArgumentException: Cannot reflectively create enum objects
 *
 * @author zab
 * @date 2024/11/9 11:14
 */
public class SingletonTest {
    public static void main(String[] args) {
        try {
            //虽然枚举实例没有公开的构造参数，但是枚举的构造函数实际上包含了两个参数：一个是String类型（实例的名称），另一个是int类型（实例的序号）
            Constructor<EnumSingleton> constructor = EnumSingleton.class.getDeclaredConstructor(String.class, int.class);
            constructor.setAccessible(true);
            EnumSingleton newInstance = constructor.newInstance("INSTANCE", 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
