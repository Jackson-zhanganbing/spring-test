package com.zab.springboot.disruptor.quickstart;

import com.lmax.disruptor.EventFactory;
/**
 * 第二步，定义一个事件工厂
 *
 * @author zab
 * @date 2024/3/29 19:47
 */
public class CommandEventFactory implements EventFactory<CommandEvent> {
    @Override
    public CommandEvent newInstance() {
        return new CommandEvent();
    }
}
