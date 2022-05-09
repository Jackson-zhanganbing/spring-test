package com.zab.springboot.aop.interceptor;

import cn.hutool.core.util.StrUtil;
import cn.hutool.http.ContentType;
import cn.hutool.json.JSONUtil;
import com.zab.springboot.common.ResponseVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * 自定义拦截器
 *
 * 1、过滤器是基于函数回调的，而拦截器是基于java反射的
 * 2、过滤器依赖于servlet容器，而拦截器不依赖与Servlet容器
 * 3、连接器几乎对所有的请求都起作用和，而拦截器只能对action请求起作用
 * 4、拦截器可以访问action的上下文，而过滤器不可以
 * 5、在action的生命周期中，拦截器可以多次调用，而过滤器只能在容器初始化的时候调用一次
 *
 * @author zab
 * @date 2021/12/14 9:53 PM
 */
@Slf4j
public class TokenInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("================TokenInterceptor preHandle================");
        String token = request.getHeader("token");

        if (StrUtil.isBlank(token)) {
            PrintWriter writer = response.getWriter();
            response.setContentType(ContentType.JSON.toString());
            response.setCharacterEncoding("UTF-8");
            writer.print(JSONUtil.toJsonStr(ResponseVo.fail("400", "TokenInterceptor==>token is missing")));
            return false;
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        log.info("================TokenInterceptor postHandle================");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
