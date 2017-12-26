package com.wx.farm.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Aspect
@Component
public class HttpAspect {

    private final static Logger log = LoggerFactory.getLogger(HttpAspect.class);

    @Pointcut("execution(public * com.wx.farm.controller.HelloController.*(..))")
    public void log(){

    }

    @Before("log()")
    public void doBefore(JoinPoint joinPoint){
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        //获取url
        log.info("url={}",request.getRequestURL());

        //获取method
        log.info("method={}",request.getMethod());

        //获取ip
        log.info("ip={}",request.getRemoteAddr());

        //获取类方法
        log.info("class_method={}",joinPoint.getSignature().getDeclaringTypeName()+"."+joinPoint.getSignature().getName());

        //获取类参数
        log.info("args={}",joinPoint.getArgs());
    }
    @After("log()")
    public void doAfter(){
        System.out.println("2222222222222");
    }
    /**
     * 获取返回的结果集
     * @param object
     */
    @AfterReturning(returning = "object",pointcut = "log()")
    public void doAfterReturn( Object object){
        log.info("response={}",object.toString());
    }

}
