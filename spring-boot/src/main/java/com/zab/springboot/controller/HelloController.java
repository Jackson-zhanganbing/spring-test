package com.zab.springboot.controller;

import com.zab.springboot.aop.AspectParam;
import com.zab.springboot.aop.ClassCheck;
import com.zab.springboot.common.ResponseVo;
import com.zab.springboot.controller.starter.StarterTestService;
import com.zab.springboot.properties.*;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * spring boot 测试
 *
 * @author zab
 * @date 2021-11-19 23:33
 */
@Slf4j
@RestController
@ClassCheck
@RequestMapping("/api")
public class HelloController extends BaseController {

    Logger logger = LoggerFactory.getLogger(HelloController.class);

    @Autowired
    private PropertiesTest1 test1;
    @Autowired
    private PropertiesTest2 test2;
    @Autowired
    private PropertiesTest3 test3;
    @Autowired
    private PropertiesTest4 test4;
    @Autowired
    private PropertiesTest5 test5;

    @Autowired
    private StarterTestService starterTestService;


    /**
     * hello测试
     */
    @RequestMapping("/hello")
    public String hello() {
        return "hello spring boot!";
    }

    /**
     * 属性测试
     */
    @RequestMapping("/properties")
    public String getProperties() {
        logger.info(test1.test1);
        logger.info(test2.test2);
        logger.info(test3.test3);
        logger.info(test4.four1);
        logger.info(test4.four2);
        logger.info(test5.relaxedBinding);
        return "ok";
    }

    /**
     * 切面增强测试
     */
    @RequestMapping("/adviceTest")
    public ResponseVo adviceTest(@RequestBody AspectParam param) {
        return ResponseVo.success(param);
    }

    /**
     * 异常测试，全局异常捕捉
     */
    @RequestMapping("/exception")
    public String exception(String s) {
        //int i = 1/0;
        String substring = s.substring(1);
        return substring;
    }

    /**
     * spring boot starter测试
     */
    @RequestMapping("/starter")
    public String starter(String s) {
        return starterTestService.starter(s);
    }

    /**
     * pathVariable测试
     */
    @RequestMapping("/{s}/test")
    public String pathVariable(@PathVariable String s) {
        return s;
    }

    /**
     * messageConverter测试
     * 转换前
     * {
     *     "code": "0",
     *     "message": "success",
     *     "data": {
     *         "names": null,
     *         "nowDate": "2021-12-09T15:14:42.510+00:00",
     *         "isBig": null,
     *         "weight": "11"
     *     }
     * }
     * 转换后
     *{
     *     "code": "0",
     *     "data": {
     *         "isBig": false,
     *         "names": [],
     *         "nowDate": "2021-12-09 23:16:05",
     *         "weight": "11"
     *     },
     *     "message": "success"
     * }
     */
    @RequestMapping("messageConverter")
    public ResponseVo<TestBean> messageConverterTest() {

        TestBean testBean = TestBean.builder()
                .isBig(null).names(null)
                .nowDate(new Date())
                .weight("11").build();
        ResponseVo responseVo = new ResponseVo();
        return responseVo.setCode("0").setMessage("success").setData(testBean);
    }

    @RequestMapping("/testDate")
    public ResponseVo testDate(@RequestBody TestBean dto){
        Date birthday = dto.getNowDate();
        log.info(birthday.toString());
        return ResponseVo.success("ok");
    }
}
