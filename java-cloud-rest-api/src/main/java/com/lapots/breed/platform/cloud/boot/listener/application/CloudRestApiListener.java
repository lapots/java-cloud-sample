package com.lapots.breed.platform.cloud.boot.listener.application;

import com.lapots.breed.platform.cloud.boot.devtools.JavaLogUtils;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.actuate.metrics.CounterService;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.ServletRequestHandledEvent;

@Component
public class CloudRestApiListener implements ApplicationListener<ApplicationEvent> {
    private static final String RANDOM_INVOKED = "/rest/person/rnd";
    private static final Logger LOGGER = JavaLogUtils.getLogger();

    private String RANDOM_CALL = "statistics.random";

    @Qualifier("counterService")
    @Autowired
    private CounterService counterService;

    @Override
    public void onApplicationEvent(ApplicationEvent applicationEvent) {
        if (applicationEvent instanceof ServletRequestHandledEvent) {
            LOGGER.info("Caught servlet request event!");
            ServletRequestHandledEvent event = (ServletRequestHandledEvent) applicationEvent;
            if (event.getRequestUrl().equals(RANDOM_INVOKED)) {
                counterService.increment(RANDOM_CALL);
            }
        }
    }
}
