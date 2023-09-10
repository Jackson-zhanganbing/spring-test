package com.zab.springboot.es.ik;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

@RestController
@RequestMapping("/ik")
@Slf4j
public class JdbcTest {

    @RequestMapping("/test")
    public void testMysqlHotWords(){
        try{
            this.getMysqlExtDictionarys();
        }catch (Exception e){

        }
    }

    private void getMysqlExtDictionarys(){
        log.info("loadMysqlExtDict===============>");
        //2.注册驱动
        try{
            Class.forName("com.mysql.jdbc.Driver");
            //3.获取数据库连接对象
            Connection conn = DriverManager.getConnection("jdbc:mysql://81.68.137.141:3306/zab?characterEncoding=utf8&characterSetResults=utf8&autoReconnect=true&failOverReadOnly=false", "root", "20103852");
            //4.定义sql语句
            String sql = "select extend_word from sys_extend_words";
            //5.获取执行sql的对象 Statement
            Statement stmt = conn.createStatement();
            //6.执行sql
            ResultSet resultSet = stmt.executeQuery(sql);
            //7.处理结果
            while(resultSet.next()) {
                //rs.next():判断该行是否有数据，返回值为true或false
                String extendWord = resultSet.getString("extend_word");
                log.info("extendWord===============>" + extendWord);
            }
            //8.释放资源
            stmt.close();
            conn.close();
        }catch (Exception e){
            log.info("loadMysqlExtDict===============>" + e.getMessage());
        }
    }
}
