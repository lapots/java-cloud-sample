package com.lapots.breed.platform.cloud.boot.exception;

import lombok.Data;
import org.springframework.context.ApplicationEvent;

@Data
public class ApplicationExceptionEvent extends ApplicationEvent {
    private ApplicationException exc;

    public ApplicationExceptionEvent(Object source, ApplicationException exc) {
        super(source);
        this.exc = exc;
    }
}
