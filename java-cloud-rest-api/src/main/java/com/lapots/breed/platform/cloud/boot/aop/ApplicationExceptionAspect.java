package com.lapots.breed.platform.cloud.boot.aop;

import com.lapots.breed.platform.cloud.boot.exception.ApplicationException;
import com.lapots.breed.platform.cloud.boot.exception.api.aop.ApplicationEventfulExceptionAspect;
import com.lapots.breed.platform.cloud.boot.exception.ApplicationExceptionEvent;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.springframework.context.ApplicationEventPublisher;

public class ApplicationExceptionAspect extends ApplicationEventfulExceptionAspect {

    public ApplicationExceptionAspect(ApplicationEventPublisher publisher) {
        super(publisher);
    }

    @Override
    @AfterThrowing(
            pointcut = "execution(* com.lapots.breed.platform.cloud.boot.*.*.*(..))",
            throwing = "ex"
    )
    public void handleApplicationException(JoinPoint jp, ApplicationException exc) {
        publisher.publishEvent(new ApplicationExceptionEvent(jp.getTarget(), exc));
    }
}
