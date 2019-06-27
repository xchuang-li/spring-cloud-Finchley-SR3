package com.lcay.cloud.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

/**
 * 拦截所有请求，打印相关请求信息
 *
 * */
@Aspect
@Component
@Slf4j
public class LogRequestAspect {
    @Pointcut("execution(public * com.lcay.cloud.controller.*.*(..))")
    public void excudeService() {
    }

    @Before("excudeService()")
    public void before(JoinPoint joinPoint) throws Throwable{
        ServletRequestAttributes servletRequestAttributes
                = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
        HttpServletRequest httpServletRequest = servletRequestAttributes.getRequest();
        log.info("url:"+httpServletRequest.getRequestURI());
        log.info("contentType:"+httpServletRequest.getContentType());
        Enumeration<String> enumeration = httpServletRequest.getParameterNames();
        while(enumeration.hasMoreElements()){
            String paramName = enumeration.nextElement();
            log.info("paramName={},paramValue={}",paramName,httpServletRequest.getParameter(paramName));
        }
    }
}
