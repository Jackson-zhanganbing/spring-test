package com.zab.designpattern.pattern.behavior.mediator;

import java.util.ArrayList;
import java.util.List;

/**
 * 聊天室实现
 *
 * @author zab
 * @date 2024/11/13 22:46
 */
public class ChatRoomImpl implements IChatRoom{

    public List<User> userList = new ArrayList<>();

    @Override
    public void sendMsg(String msg, User user) {
        for (User u : userList) {
            if(u != user){
                u.receive(msg);
            }
        }
    }

    @Override
    public void addUser(User user) {
        userList.add(user);
    }
}
