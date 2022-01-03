package com.zab.springboot.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * 宽绑定，校验
 *
 * @author zab
 * @date 2021-12-06 22:36
 */
@ConfigurationProperties(prefix = "test5")
@Validated
@Data
public class PropertiesTest5 {
    @NotNull
    public String relaxedBinding;
    /**
     * 嵌套类，需要添加valid注解才能校验到内部的字段
     */
    @Valid
    private Security security;

    public static class Security {
        @NotEmpty
        private String username;

        public String getUsername() {
            return this.username;
        }

        public void setUsername(String username) {
            this.username = username;
        }
    }
}
