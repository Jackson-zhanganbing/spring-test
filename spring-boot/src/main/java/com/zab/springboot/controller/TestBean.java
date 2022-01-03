package com.zab.springboot.controller;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

/**
 * 测试返回类
 *
 * @author zab
 * @date 2021-12-09 23:10
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TestBean {
    private List<String> names;

    private Date nowDate;

    private Boolean isBig;

    private String weight;

}
