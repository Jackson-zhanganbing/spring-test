package com.zab.springboot.aop;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * description
 *
 * @author zab
 * @date 2021-12-07 22:19
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AspectParam {
    private String name;
    private String code;
}
