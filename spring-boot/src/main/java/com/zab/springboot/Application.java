package com.zab.springboot;

import com.zab.springboot.enableannotation.EnableLogin;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * springboot 测试
 *
 * @author zab
 * @date 2021-11-21 21:16
 */
@EnableLogin
@SpringBootApplication
@MapperScan(basePackages = "com.zab.springboot.project.mapper")
@ServletComponentScan("com.zab.springboot.aop.filter")
public class Application {

    public static void main(String[] args) {
        //默认初始springboot的启动代码
        //SpringApplication.run(Application.class, args);
        //定制化代码，关闭banner
        SpringApplication springApplication = new SpringApplication(Application.class);
        springApplication.setBannerMode(Banner.Mode.OFF);
        //关闭命令行参数
        springApplication.setAddCommandLineProperties(false);
        springApplication.run(args);

        //流式启动springboot
/*        new SpringApplicationBuilder()
                .bannerMode(Banner.Mode.OFF)
                .run(args);*/
    }

}
