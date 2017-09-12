package com.lapots.breed.platform.cloud.boot.logging.amqp;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//@Component
public class LoggingMessageProducer {

    private AMQPProperties properties;
    private RabbitTemplate template;

    @Autowired
    public LoggingMessageProducer(RabbitTemplate template, AMQPProperties properties) {
        this.template = template;
        this.properties = properties;
    }

    public void sendLoggingMessage(String message) {
        this.template.convertAndSend(properties.getLoggingExchange(), properties.getLoggingQueue(), message);
    }
}
