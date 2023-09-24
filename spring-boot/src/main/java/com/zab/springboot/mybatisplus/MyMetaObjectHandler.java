package com.zab.springboot.mybatisplus;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * 自动插入公有字段
 *
 * @author zab
 * @date 2023/9/24 18:38
 */
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {
    /*** 插入时的填充策略* @param metaObject*/
    @Override
    public void insertFill(MetaObject metaObject) {
        Object createTime = metaObject.getValue("createTime");
        Object updateTime = metaObject.getValue("updateTime");
        Object createBy = metaObject.getValue("createBy");
        Object updateBy = metaObject.getValue("updateBy");

        if(createTime == null){
            this.setFieldValByName("createTime", new Date(), metaObject);
        }

        if(updateTime == null){
            this.setFieldValByName("updateTime", new Date(), metaObject);
        }
        if(createBy == null){
            this.setFieldValByName("createBy", "system", metaObject);
        }


        if(updateBy == null){
            this.setFieldValByName("updateBy", "system", metaObject);
        }
    }

    /*** 更新时的填充策略* @param metaObject*/
    @Override
    public void updateFill(MetaObject metaObject) {
        this.setFieldValByName("updateTime", new Date(), metaObject);
    }
}