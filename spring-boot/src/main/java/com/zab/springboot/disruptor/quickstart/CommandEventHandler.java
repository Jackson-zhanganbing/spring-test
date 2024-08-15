package com.zab.springboot.disruptor.quickstart;

import com.lmax.disruptor.EventHandler;
import com.lmax.disruptor.RingBuffer;
import lombok.extern.slf4j.Slf4j;

/**
 * 第三步，定义一个事件处理器，消费者
 *
 * @author zab
 * @date 2024/3/29 19:49
 */
@Slf4j
public class CommandEventHandler implements EventHandler<CommandEvent> {
    /**
     * Called when a publisher has published an event to the {@link RingBuffer}
     * 事件回调
     *
     */
    @Override
    public void onEvent(CommandEvent commandEvent, long sequence, boolean endOfBatch) throws Exception {
        log.info("commandEvent: {}, sequence: {}, endOfBatch: {}", commandEvent, sequence, endOfBatch);
    }
}
