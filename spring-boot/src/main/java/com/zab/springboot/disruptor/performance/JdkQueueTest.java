package com.zab.springboot.disruptor.performance;

import com.zab.springboot.disruptor.Constants;
import com.zab.springboot.disruptor.quickstart.CommandEvent;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * jdk自带队列，生产消费效率测试
 *
 * @author zab
 * @date 2024/3/29 20:52
 */
@Slf4j
public class JdkQueueTest {

    public static void main(String[] args) {
        final ArrayBlockingQueue<CommandEvent> queue = new ArrayBlockingQueue<>(Constants.EVENT_NUM);
        final long startTime = System.currentTimeMillis();
        // 向容器中添加数据
        new Thread(() -> {
            long i = 0;
            while (i < Constants.EVENT_NUM){
                CommandEvent data = new CommandEvent(""+i);
                try {
                    queue.put(data);
                } catch (InterruptedException e) {
                    log.error("添加数据错误： ", e);
                }
                i++;
            }
        }).start();
        // 从容器中获取数据
        new Thread(() -> {
            long k = 0;
            while (k < Constants.EVENT_NUM){
                try {
                    queue.take();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                k++;
            }
            long endTime = System.currentTimeMillis();
            log.info("ArrayBlockingQueue costTime:" + (endTime - startTime) + "ms");
        }).start();

    }
}
