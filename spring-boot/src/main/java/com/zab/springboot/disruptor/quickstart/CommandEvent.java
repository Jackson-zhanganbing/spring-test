package com.zab.springboot.disruptor.quickstart;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 第一步，定义一个事件类，指令上报事件
 *
 * @author zab
 * @date 2024/3/29 19:45
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CommandEvent {
    private String cmd;
}
