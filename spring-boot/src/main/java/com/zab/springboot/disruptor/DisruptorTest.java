package com.zab.springboot.disruptor;

import com.lmax.disruptor.BlockingWaitStrategy;
import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.ProducerType;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * disruptor测试
 *
 * @author zab
 * @date 2024/3/29 20:02
 */
public class DisruptorTest {
    public static void main(String[] args) {

        CommandEventFactory factory = new CommandEventFactory();

        int ringBufferSize = 1024;

        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

        /**
         * Create a new Disruptor.
         *
         * @param eventFactory   the factory to create events in the ring buffer.
         * @param ringBufferSize the size of the ring buffer, must be power of 2.这里写了：必须2的n次方
         * @param executor       an {@link Executor} to execute event processors.
         * @param producerType   the claim strategy to use for the ring buffer.
         * @param waitStrategy   the wait strategy to use for the ring buffer.
         */
        //第一步： 实例化Disruptor
        Disruptor<CommandEvent> disruptor = new Disruptor<CommandEvent>(factory, ringBufferSize, fixedThreadPool, ProducerType.SINGLE, new BlockingWaitStrategy());

        //第二步： 设置事件监听
        disruptor.handleEventsWith(new CommandEventHandler());

        //第三步： 启动disruptor
        disruptor.start();

        //第四步： 取出disruptor的ringBuffer
        RingBuffer<CommandEvent> ringBuffer = disruptor.getRingBuffer();

        //第五步： 用刚刚的ringBuffer构建事件生产者
        CommandEventProducer commandEventProducer = new CommandEventProducer(ringBuffer);

        //第六步： 循环生产消息，观察事件回调
        for (int i = 0; i < 1000; i++) {
            commandEventProducer.produceEvent(""+i);
        }

        //第七步： 关闭disruptor
        //这里会自己等待消息处理完成后才关闭
        disruptor.shutdown();
        fixedThreadPool.shutdown();
    }
}
