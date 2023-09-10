package com.zab.springboot.common.verification;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * 参数
 *
 * @author zab
 * @date 2023/9/10 19:58
 */
@Data
public class ParamTest {

    @NotBlank(message = "参数1不允许为空")
    private String param1;

    @NotNull(message = "参数2不允许为空")
    private Integer param2;

    @MyDateTime(dateOrTime = 1, message = "日期不正确哦", format = "yyyy-MM-dd HH:mm:ss", isContainDetail = true)
    private String param3;
}
