package com.lapots.breed.platform.cloud.boot.exception;

import com.lapots.breed.platform.cloud.boot.exception.api.ApplicationExceptionListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.actuate.metrics.CounterService;
import org.springframework.stereotype.Component;

@Component
public class IncrementalApplicationExceptionListener implements ApplicationExceptionListener {
    private static final String EXCEPTION_CALL = "application.exception.count";

    @Qualifier("counterService")
    @Autowired
    private CounterService counterService;

    @Override
    public void onApplicationEvent(ApplicationExceptionEvent exceptionEvent) {
        counterService.increment(EXCEPTION_CALL);
    }
}
