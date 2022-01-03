package com.zab.springboot.common;

import javax.servlet.ReadListener;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * HttpServletRequest，在切面注入后，直接从HttpServletRequest获取
 * body要报错，原因是getReader和getInputStream方法只能用一次
 *
 * @author zab
 * @date 2021/12/20 11:42 PM
 */
public class MyRequestWrapper extends HttpServletRequestWrapper {
    private final byte[] body;

    public MyRequestWrapper(HttpServletRequest request, byte[] body) {
        super(request);
        this.body = body;
    }

    public byte[] getBody() {
        return body;
    }

    @Override
    public ServletInputStream getInputStream() throws IOException {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(body);
        return new ServletInputStream() {

            @Override
            public int read() throws IOException {
                return byteArrayInputStream.read();
            }

            @Override
            public void setReadListener(ReadListener listener) {
            }

            @Override
            public boolean isReady() {
                return true;
            }

            @Override
            public boolean isFinished() {
                return false;
            }
        };
    }

    public MyRequestWrapper(HttpServletRequest request) throws IOException {
        super(request);

        StringBuilder sb = new StringBuilder();
        String line;
        BufferedReader reader = request.getReader();
        while ((line = reader.readLine()) != null) {
            sb.append(line);
        }
        String body = sb.toString();
        this.body = body.getBytes(StandardCharsets.UTF_8);
    }


    public String getBodyStr() {
        return new String(body, StandardCharsets.UTF_8);
    }
}