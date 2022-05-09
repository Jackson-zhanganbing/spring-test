package com.zab.springboot.webconfig;


import cn.hutool.core.util.StrUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * 自定义日期转换器
 *
 * @author zab
 * @date 2022/5/8 22:33
 */
@Slf4j
public class DateConverter implements Converter<String, Date> {
    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Override
    public Date convert(String source) {
        Date date = new Date();
        if (!StrUtil.isBlank(source)) {
            try {
                date = simpleDateFormat.parse(source);
            } catch (ParseException e) {
                log.info(e.getMessage());
            }
        }
        return date;
    }
}
