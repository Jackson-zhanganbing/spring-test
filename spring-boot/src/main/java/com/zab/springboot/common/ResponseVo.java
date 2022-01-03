package com.zab.springboot.common;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * response
 *
 * @author zab
 * @date 2021-12-03 23:51
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class ResponseVo<T> {
    private String code;
    private String message;
    private T data;

    public static <T> ResponseVo<T> success(T data){
        return ResponseVo.<T>builder().code("0").message("success").data(data).build();
    }
    public static <T> ResponseVo<T> fail(String code, String message){
        return ResponseVo.<T>builder().code(code).message(message).data(null).build();
    }

}
