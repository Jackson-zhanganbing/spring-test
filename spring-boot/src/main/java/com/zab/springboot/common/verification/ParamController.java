package com.zab.springboot.common.verification;

import cn.hutool.json.JSONUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


/**
 * 参数校验
 *
 * @author zab
 * @date 2023/9/10 20:04
 */
@RequestMapping("/param")
@RestController
@Slf4j
public class ParamController {

    @PostMapping("/test-param")
    public void testParam(@RequestBody @Valid ParamTest paramTest){
        MyConstraintValidator validator = new MyConstraintValidator();
        log.info(JSONUtil.toJsonStr(paramTest));
    }
}
