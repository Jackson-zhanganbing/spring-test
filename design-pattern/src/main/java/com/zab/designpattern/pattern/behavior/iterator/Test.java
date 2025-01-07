package com.zab.designpattern.pattern.behavior.iterator;

import java.util.ArrayList;
import java.util.List;

/**
 * 迭代器测试类
 *
 * @author zab
 * @date 2024/11/12 22:40
 */
public class Test {
    public static void main(String[] args) {
        List<String> carNameList = new ArrayList<String>();
        carNameList.add("深蓝");
        carNameList.add("长安");
        carNameList.add("启源");

        IteratorImpl iterator = new IteratorImpl(carNameList);

        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
