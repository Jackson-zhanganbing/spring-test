package com.zab.springboot.disruptor.performance;

import com.lmax.disruptor.EventFactory;
import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.YieldingWaitStrategy;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.ProducerType;
import com.zab.springboot.disruptor.Constants;
import com.zab.springboot.disruptor.quickstart.CommandEvent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Disruptor挑战一下jdk自带队列的效率
 *
 * @author zab
 * @date 2024/3/29 20:57
 */
public class DisruptorPerformanceTest {
    public static void main(String[] args) {

        ExecutorService executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        int ringBufferSize = 65536;

        Disruptor<CommandEvent> disruptor = new Disruptor<CommandEvent>(
                () -> new CommandEvent(),
                ringBufferSize,
                executor,
                ProducerType.SINGLE,
                new YieldingWaitStrategy());


        CommandConsumer consumer = new CommandConsumer();
        // 消费数据
        disruptor.handleEventsWith(consumer);
        disruptor.start();
        new Thread(() -> {
            RingBuffer<CommandEvent> ringBuffer = disruptor.getRingBuffer();
            for (long i = 0; i < Constants.EVENT_NUM; i++) {
                long seq = ringBuffer.next();
                CommandEvent data = ringBuffer.get(seq);
                data.setCmd("cmd:" + i);
                ringBuffer.publish(seq);
            }
        }).start();

    }
}
