package com.zab.designpattern.pattern.behavior.mediator;

/**
 * 中介者模式测试
 *
 * @author zab
 * @date 2024/11/13 22:51
 */
public class Test {
    public static void main(String[] args) {
        IChatRoom chatRoom = new ChatRoomImpl();
        User user1 = new User("张三", chatRoom);
        User user2 = new User("李四", chatRoom);
        User user3 = new User("王五", chatRoom);

        user1.sendMsg("你们好", chatRoom);
        System.out.println("=======================");

        user2.sendMsg("你们好", chatRoom);
        System.out.println("=======================");

        user3.sendMsg("你们好", chatRoom);
    }
}
