package com.lapots.breed.platform.cloud.boot.exception.api.aop;

import com.lapots.breed.platform.cloud.boot.exception.ApplicationException;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Aspect
@Component
public abstract class ApplicationEventfulExceptionAspect {
    protected ApplicationEventPublisher publisher;

    @Autowired
    public ApplicationEventfulExceptionAspect(ApplicationEventPublisher publisher) {
        this.publisher = publisher;
    }

    // TODO: investigate how to provide exception signature in aspect annotation instead of implementation
    /**
     * Suppose to keep logic about publishing events.
     * @param jp
     * @param exc
     */
    public abstract void handleApplicationException(JoinPoint jp, ApplicationException exc);
}
