package com.zab.designpattern.pattern.behavior.mediator;

/**
 * 聊天室
 *
 * @author zab
 * @date 2024/11/13 22:44
 */
public interface IChatRoom {

    /**
     * 聊天室显示消息
     */
    void showMsg(User user, String msg);

}
