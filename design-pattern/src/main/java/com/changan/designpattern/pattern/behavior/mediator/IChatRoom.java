package com.changan.designpattern.pattern.behavior.mediator;

/**
 * 聊天室
 *
 * @author zab
 * @date 2024/11/13 22:44
 */
public interface IChatRoom {
    /**
     * 用户发送消息
     */
    void sendMsg(String msg, User user);

    /**
     * 新增用户
     */
    void addUser(User user);

}
