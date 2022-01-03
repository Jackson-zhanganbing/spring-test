package com.zab.springboot;

import cn.hutool.json.JSONUtil;
import com.zab.springboot.aop.AspectParam;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class ApplicationTests {

    @Autowired
    MockMvc mvc;
    @Test
    void testWithMockMvc() throws Exception {
        AspectParam zhangsan = AspectParam.builder().code("007").name("zhangsan").build();
        mvc.perform(
                 post("/api/adviceTest")
                .contentType(MediaType.APPLICATION_JSON)
                .content(JSONUtil.toJsonStr(zhangsan))
                 )
                .andExpect(status().isOk())
                .andExpect(content().string("zhangsan"));
    }
}
