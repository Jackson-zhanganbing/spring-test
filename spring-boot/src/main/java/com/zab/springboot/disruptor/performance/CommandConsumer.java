package com.zab.springboot.disruptor.performance;

import com.lmax.disruptor.EventHandler;
import com.zab.springboot.disruptor.Constants;
import com.zab.springboot.disruptor.quickstart.CommandEvent;
import lombok.extern.slf4j.Slf4j;

/**
 * 测试性能的消费者
 *
 * @author zab
 * @date 2024/3/29 21:00
 */
@Slf4j
public class CommandConsumer implements EventHandler<CommandEvent> {
    private long startTime;
    private int i;

    public CommandConsumer() {
        this.startTime = System.currentTimeMillis();
    }

    @Override
    public void onEvent(CommandEvent event, long sequence, boolean endOfBatch) throws Exception {
        sequence++;
        if (sequence >= Constants.EVENT_NUM) {
            long endTime = System.currentTimeMillis();
            log.info("Disruptor costTime = " + (endTime - startTime) + "ms");
        }
    }
}
