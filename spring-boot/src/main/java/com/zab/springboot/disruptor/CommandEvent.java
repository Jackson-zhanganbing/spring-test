package com.zab.springboot.disruptor;

import lombok.Data;

/**
 * 第一步，定义一个事件类，指令上报事件
 *
 * @author zab
 * @date 2024/3/29 19:45
 */
@Data
public class CommandEvent {
    private String cmd;
}
