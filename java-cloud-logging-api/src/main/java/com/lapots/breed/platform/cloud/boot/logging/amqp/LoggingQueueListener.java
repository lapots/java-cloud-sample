package com.lapots.breed.platform.cloud.boot.logging.amqp;

import com.lapots.breed.platform.cloud.boot.devtools.JavaLogUtils;
import org.slf4j.Logger;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.stereotype.Component;

//@Component("amqpQueueListener")
public class LoggingQueueListener implements MessageListener {
    private static final Logger LOGGER = JavaLogUtils.getLogger();

    @Override
    public void onMessage(Message message) {
        LOGGER.info("Got a message from RabbitMQ: {}.", message);
    }
}
