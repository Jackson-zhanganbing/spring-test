package com.sms.starter.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 消息dto
 *
 * @author zab
 * @date 2021-12-08 23:14
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class SendSmsDTO {
    /**
     * 模板ID
     */
    private String templateid;
    /**
     * 参数
     */
    private String param;
    /**
     * 手机号
     */
    private String mobile;
    /**
     * 用户穿透ID，可以为空
     */
    private String uid;
}