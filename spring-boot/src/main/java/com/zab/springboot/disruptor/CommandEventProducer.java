package com.zab.springboot.disruptor;

import com.lmax.disruptor.RingBuffer;

/**
 * 第四步：定义一个生产者，指令事件生产者
 *
 * @author zab
 * @date 2024/3/29 19:54
 */
public class CommandEventProducer {
    private RingBuffer<CommandEvent> ringBuffer;

    public CommandEventProducer(RingBuffer<CommandEvent> ringBuffer) {
        this.ringBuffer = ringBuffer;
    }

    public void produceEvent(String cmd){
        //第一步：获取ringBuffer的下一个可用的空对象下标
        long next = ringBuffer.next();

        //第二步：从ringBuffer取出来，并放回去
        CommandEvent commandEvent = ringBuffer.get(next);
        commandEvent.setCmd(cmd);

        //第三步：发布
        ringBuffer.publish(next);
    }

    public void produceEvent1(String cmd){
        // 采用try finally 这样保证事件一定发布 ，如果我们使用RingBuffer.next获取一个事件槽，那么就一定要发布对应的事件
        // 如果不能发布事件，那么会引起Disruptor状态混乱，尤其是在多个事件生产者的情况下会导致消费者失速，从而不得不重启应用来恢复
        //第一步：获取ringBuffer的下一个可用的空对象下标
        long next = ringBuffer.next();

        try{
            //第二步：从ringBuffer取出来，并放回去
            CommandEvent commandEvent = ringBuffer.get(next);
            commandEvent.setCmd(cmd);
        }finally {
            //第三步：发布
            ringBuffer.publish(next);
        }

    }
}
