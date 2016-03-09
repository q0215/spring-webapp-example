package com.github.q9029.webapp.controller.proxy;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
final class ControllerLogger {

    private ControllerLogger() {}

    /** LOGGER */
    private final Logger LOGGER = Logger.getLogger(this.getClass());

    @Before("execution(* com.github.q9029.webapp.controller.*.*(..))")
    public void beforMethod(JoinPoint joinPoint) {
        String cName = joinPoint.getTarget().getClass().getName();
        String mName = joinPoint.getSignature().getName();
        LOGGER.debug("before:" + cName + "." + mName + "()");
    }

    @After("execution(* com.github.q9029.webapp.controller.*.*(..))")
    public void afterMethod(JoinPoint joinPoint) {
        String cName = joinPoint.getTarget().getClass().getName();
        String mName = joinPoint.getSignature().getName();
        LOGGER.debug("after:" + cName + "." + mName + "()");
    }
}
