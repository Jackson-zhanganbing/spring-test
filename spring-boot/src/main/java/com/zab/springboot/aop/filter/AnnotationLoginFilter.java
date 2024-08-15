package com.zab.springboot.aop.filter;

import cn.hutool.core.util.StrUtil;
import cn.hutool.http.ContentType;
import cn.hutool.json.JSONUtil;
import com.zab.springboot.common.ResponseVo;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 注解标记的过滤器，注意，如果用了WebFilter注解，
 * 必须在启动类上扫描，因为这个注解不是spring提供的
 *
 * @author zab
 * @date 2021/12/14 10:45 PM
 */
@WebFilter(urlPatterns = "/*", filterName = "AnnotationLoginFilter")
public class AnnotationLoginFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest)servletRequest;
        String token = request.getHeader("token");
        //临时去掉
        if (StrUtil.isBlank(token)) {
            filterChain.doFilter(servletRequest,servletResponse);
            return;
        }
        if(StrUtil.isBlank(token)){
            PrintWriter writer = servletResponse.getWriter();
            servletResponse.setContentType(ContentType.JSON.toString());
            servletResponse.setCharacterEncoding("UTF-8");
            writer.print(JSONUtil.toJsonStr(ResponseVo.fail("400","AnnotationLoginFilter==>token is missing")));
        }

        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
