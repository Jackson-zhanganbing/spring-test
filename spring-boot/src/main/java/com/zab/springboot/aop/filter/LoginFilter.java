package com.zab.springboot.aop.filter;

import cn.hutool.core.util.StrUtil;
import cn.hutool.http.ContentType;
import cn.hutool.json.JSONUtil;
import com.zab.springboot.common.MyRequestWrapper;
import com.zab.springboot.common.ResponseVo;
import com.zab.springboot.common.ThreadLocalUtil;
import org.springframework.web.multipart.MultipartRequest;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 1、Filter是依赖于Servlet容器，属于Servlet规范的一部分，
 *    而拦截器则是独立存在的，可以在任何情况下使用。
 * 2、Filter的执行由Servlet容器回调完成，而拦截器通常通过动态代理的方式来执行。
 * 3、Filter的生命周期由Servlet容器管理，而拦截器则可以通过IoC容器来管理，
 *    因此可以通过注入等方式来获取其他Bean的实例，因此使用会更方便。
 *
 * @author zab
 * @date 2021/12/14 10:18 PM
 */
public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest)servletRequest;
        String token = request.getHeader("token");
        // 转换成自己覆写的类，这样做，可以重复利用request的参数
        MyRequestWrapper myRequestWrapper = new MyRequestWrapper(request);
        ThreadLocalUtil.set("requestBody", myRequestWrapper.getBodyStr());

        if(StrUtil.isBlank(token)){
            PrintWriter writer = servletResponse.getWriter();
            servletResponse.setContentType(ContentType.JSON.toString());
            servletResponse.setCharacterEncoding("UTF-8");
            writer.print(JSONUtil.toJsonStr(ResponseVo.fail("400","LoginFilter==>token is missing")));
        }

        filterChain.doFilter(myRequestWrapper,servletResponse);

    }

    @Override
    public void destroy() {
    }
}
