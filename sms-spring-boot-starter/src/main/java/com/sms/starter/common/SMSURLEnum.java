package com.sms.starter.common;

import lombok.Getter;
/**
 * description
 *
 * @author zab
 * @date 2021-12-08 23:21
 */
@Getter
public enum SMSURLEnum {
    //云之讯，开放平台的链接
    SENDSMS("https://open.ucpaas.com/ol/sms/sendsms"),
    SENDBATCHSMS("https://open.ucpaas.com/ol/sms/sendsms_batch");
    private String url;
    SMSURLEnum(String url) {
        this.url = url;
    }
}