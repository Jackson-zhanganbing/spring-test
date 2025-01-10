package com.zab.designpattern.pattern.behavior.mediator;

import java.util.Date;

/**
 * 聊天室实现
 *
 * @author zab
 * @date 2024/11/13 22:46
 */
public class ChatRoomImpl implements IChatRoom{

    @Override
    public void showMsg(User user, String msg) {
        System.out.println(new Date().toString() + " [" + user.getName() +"] : " + msg);
    }

}
