package com.github.q9029.webapp.proxy.impl;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import com.github.q9029.webapp.proxy.LoggerProxy;

@Aspect
@Component
public final class DaoLoggerProxyImpl extends LoggerProxy {

    private DaoLoggerProxyImpl() {}

    @Before("execution(* com.github.q9029.webapp.dao.*.*(..))")
    public void beforeMethod(JoinPoint joinPoint) {
        super.beforMethod(joinPoint);
    }

    @After("execution(* com.github.q9029.webapp.dao.*.*(..))")
    public void afterMethod(JoinPoint joinPoint) {
        super.afterMethod(joinPoint);
    }
}
