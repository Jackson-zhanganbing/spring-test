package com.zab.designpattern.pattern.behavior.mediator;

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
    }

    public void sendMsg(String msg, IChatRoom chatRoom){
        chatRoom.showMsg(this, msg);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public IChatRoom getChatRoom() {
        return chatRoom;
    }

    public void setChatRoom(IChatRoom chatRoom) {
        this.chatRoom = chatRoom;
    }
}
