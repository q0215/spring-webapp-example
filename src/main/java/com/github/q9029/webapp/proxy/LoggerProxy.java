package com.github.q9029.webapp.proxy;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;

public abstract class LoggerProxy {

    private static final Logger LOGGER = Logger.getLogger(LoggerProxy.class);

    public void beforMethod(JoinPoint joinPoint) {
        String cName = joinPoint.getTarget().getClass().getName();
        String mName = joinPoint.getSignature().getName();
        LOGGER.debug("before:" + cName + "." + mName + "()");
    }

    public void afterMethod(JoinPoint joinPoint) {
        String cName = joinPoint.getTarget().getClass().getName();
        String mName = joinPoint.getSignature().getName();
        LOGGER.debug("after:" + cName + "." + mName + "()");
    }
}
