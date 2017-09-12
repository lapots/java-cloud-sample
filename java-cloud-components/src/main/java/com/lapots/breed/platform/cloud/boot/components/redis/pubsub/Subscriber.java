package com.lapots.breed.platform.cloud.boot.components.redis.pubsub;

import com.lapots.breed.platform.cloud.boot.devtools.JavaLogUtils;
import org.slf4j.Logger;
import org.springframework.stereotype.Component;

//@Component
public class Subscriber {
    private static final Logger LOGGER = JavaLogUtils.getLogger();

    // one of the method it should be compliant to
    public void handleMessage(String message) {
        LOGGER.info("Got message: {}", message);
    }

}
