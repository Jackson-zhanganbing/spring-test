package com.zab.springboot.corefeature.factorybean;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

/**
 * FactoryBean获取bean会隐藏bean的创建细节
 *
 * @author zab
 * @date 2022/5/8 21:51
 */
@Component
public class MyFactoryBean implements FactoryBean {
    @Override
    public Object getObject() throws Exception {
        return buildMe(getBody(), getSoul());
    }

    private String getBody(){
        return "body";
    }
    private String getSoul(){
        return "soul";
    }

    private String buildMe(String body, String soul){
        return "out: "+body +" in: "+ soul;
    }

    @Override
    public Class<?> getObjectType() {
        return null;
    }
}
