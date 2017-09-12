package com.lapots.breed.platform.cloud.boot.logging.jms;

import com.lapots.breed.platform.cloud.boot.devtools.JavaLogUtils;
import org.slf4j.Logger;
import org.springframework.stereotype.Component;

import javax.jms.Message;
import javax.jms.MessageListener;

@Component("jmsQueueListener")
public class LoggingQueueListener implements MessageListener {
    private static final Logger LOGGER = JavaLogUtils.getLogger();

    @Override
    public void onMessage(Message message) {
        LOGGER.info("Got a message from ActiveMQ: {}.", message);
    }
}
