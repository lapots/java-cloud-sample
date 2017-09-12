package com.lapots.breed.platform.cloud.boot.logging.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public abstract class LoggingAspect {
    /**
     * Main entry point for logging.
     * @param jp joint point
     */
    public abstract void log(JoinPoint jp);
}
