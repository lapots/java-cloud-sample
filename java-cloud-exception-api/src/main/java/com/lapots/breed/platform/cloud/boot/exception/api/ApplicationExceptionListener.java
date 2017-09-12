package com.lapots.breed.platform.cloud.boot.exception.api;

import com.lapots.breed.platform.cloud.boot.exception.ApplicationException;
import com.lapots.breed.platform.cloud.boot.exception.ApplicationExceptionEvent;
import org.springframework.context.ApplicationListener;

/**
 * Listener for {@link ApplicationException}.
 */
public interface ApplicationExceptionListener extends ApplicationListener<ApplicationExceptionEvent> {
}
