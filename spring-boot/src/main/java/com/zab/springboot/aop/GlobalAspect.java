package com.zab.springboot.aop;

import cn.hutool.json.JSONUtil;
import com.zab.springboot.common.ThreadLocalUtil;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * aop 切面使用
 *
 * @author zab
 * @date 2021-12-01 23:10
 */
@Aspect
@Component
public class GlobalAspect {

    private Logger logger = LoggerFactory.getLogger(GlobalAspect.class);
    @Autowired
    private HttpServletRequest request;
    /**
     * 定义切入点
     *
     * 切方法
     * ("execution(public * com.zab.springboot.controller.*.*(..))")
     * 切注解标记的方法
     * ("@annotation(com.zab.springboot.aop.MethodCheck)")
     * 切文件夹中所有类的所有方法
     * ("within(com.zab.springboot.controller.*)")
     * 切某个类中的所有方法
     * ("this(com.zab.springboot.controller.HelloController)")
     * 切某个父类或者接口的子类或者实习类
     * ("target(com.zab.springboot.controller.BaseController)")
     * 切被注解标记的类中的所有方法
     *("@within(com.zab.springboot.aop.ClassCheck)")
     *
     * args、@target、@args报错！
     */
    @Pointcut("@within(com.zab.springboot.aop.ClassCheck)")
    public void controllerLog() {
    }

    /**
     * 前置通知：在连接点之前执行的通知
     *
     * @param joinPoint
     * @throws Throwable
     */
    @Before("controllerLog()")
    public void doBefore(JoinPoint joinPoint) throws Throwable {
        logger.info("Before");
    }

    @AfterReturning(returning = "ret", pointcut = "controllerLog()")
    public void doAfterReturning(Object ret) throws Throwable {
        logger.info("AfterReturning : " + ret);
    }

    @Around(value = "controllerLog()")
    public Object doAround(ProceedingJoinPoint joinPoint) throws Throwable {
        StringBuffer requestURL = request.getRequestURL();
        Object requestBody = ThreadLocalUtil.get("requestBody");

        logger.info("请求url：{}", requestURL);
        Object[] args = joinPoint.getArgs();

        logger.info("请求参数From request：{}", requestBody);
        logger.info("请求参数：{}", JSONUtil.toJsonPrettyStr(args));
        Object proceed = joinPoint.proceed();
        logger.info("请求结果：{}", JSONUtil.toJsonPrettyStr(proceed));

        return proceed;
    }

    @AfterThrowing(value = "controllerLog()",throwing = "exception")
    public void doAfterThrowingAdvice(JoinPoint joinPoint,Throwable exception){
        //目标方法名：
        logger.info(joinPoint.getSignature().getName());
        if(exception instanceof NullPointerException){
            logger.info("AfterThrowing发生了空指针异常!!!!!");
        }
    }

    @After(value = "controllerLog()")
    public void doAfterAdvice(JoinPoint joinPoint){
        logger.info("After!!!!");
    }
}
