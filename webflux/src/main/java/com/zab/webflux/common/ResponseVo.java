package com.zab.webflux.common;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * response
 *
 * @author zab
 * @date 2021-12-03 23:51
 */
@Data
@Accessors(chain = true)
public class ResponseVo<T> {
    private String code;
    private String message;
    private T data;
}
