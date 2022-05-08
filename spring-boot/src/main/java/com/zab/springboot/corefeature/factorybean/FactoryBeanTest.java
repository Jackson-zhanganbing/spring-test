package com.zab.springboot.corefeature.factorybean;

import cn.hutool.json.JSONUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.WebApplicationContextUtils;

/**
 * 工厂bean测试
 *
 * @author zab
 * @date 2022/5/8 21:59
 */
@Component
@Slf4j
public class FactoryBeanTest implements ApplicationContextAware {
    private ApplicationContext applicationContext;
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    public void testFactoryBean(){
        Object myFactoryBean = applicationContext.getBean("myFactoryBean");
        Object myFactoryBean1 = applicationContext.getBean("&myFactoryBean");

        log.info(myFactoryBean.toString());
        log.info(JSONUtil.toJsonPrettyStr(myFactoryBean1));
    }
}
