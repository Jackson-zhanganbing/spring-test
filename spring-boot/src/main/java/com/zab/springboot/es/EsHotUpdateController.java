package com.zab.springboot.es;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * es热更新示例
 * 什么是es热更新？
 * es有一些中文分词扩展词、停用词，可以通过远程调接口的方式实现热更新，本地更新文件，需要重启，通过这种方式不用重启es
 *
 * @author zab
 * @date 2023/1/12 21:53
 */
@RestController
@RequestMapping("/es")
@Slf4j
public class EsHotUpdateController {

    @RequestMapping("/hotUpdate")
    public void hotUpdateEsWords(int type, HttpServletResponse response) {
        File hotWordsFile = new File(type == 1 ? "D:\\soft\\es备用文件夹\\hotword\\my_stop_words.txt":"D:\\soft\\es备用文件夹\\hotword\\my_extend_words.txt");
        FileInputStream fis = null;
        ServletOutputStream outputStream = null;
        try {
            outputStream = response.getOutputStream();
            fis = new FileInputStream(hotWordsFile);
            byte[] buffer = new byte[1024];
            while (fis.read(buffer) != -1) {
                outputStream.write(buffer);
            }


        } catch (IOException e) {
            log.error("读取扩展词失败", e);
        }
        response.setContentType("text/html;charset=utf-8");
        response.setHeader("Last-Modified", ""+hotWordsFile.length());
        response.setHeader("ETag", ""+hotWordsFile.length());
        try {
            if(outputStream != null){
                outputStream.flush();
            }
        } catch (IOException e) {
            log.error("flush扩展词失败", e);
        }
    }
}
