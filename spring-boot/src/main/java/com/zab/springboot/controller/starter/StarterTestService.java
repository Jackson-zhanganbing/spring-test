package com.zab.springboot.controller.starter;

import com.sms.starter.dto.SendSmsDTO;
import com.sms.starter.service.SmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 测试starter的服务
 *
 * @author zab
 * @date 2021-12-08 23:11
 */
@Service
public class StarterTestService {

    @Autowired
    private SmsService smsService;


    public String starter(String s) {
        SendSmsDTO dto = SendSmsDTO.builder()
                .mobile("15330355750")
                .param("xxxtest")
                .templateid("111")
                .uid("uid")
                .build();

        return smsService.sendSMS(dto);
    }
}
