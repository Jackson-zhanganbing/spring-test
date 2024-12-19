package com.changan.designpattern.pattern.behavior.mediator;

/**
 * 用户
 *
 * @author zab
 * @date 2024/11/13 22:44
 */
public class User {

    private String name;
    private IChatRoom chatRoom;

    public User(String name, IChatRoom chatRoom) {
        this.name = name;
        this.chatRoom = chatRoom;

        chatRoom.addUser(this);
    }

    public void sendMsg(String msg, IChatRoom chatRoom){
        System.out.println(name + "发送了: " + msg);
        chatRoom.sendMsg(msg, this);
    }

    public void receive(String msg) {
        System.out.println(name + "收到聊天室消息：" + msg);
    }
}
