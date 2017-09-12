package com.lapots.breed.platform.cloud.boot.logging.jms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class LoggingMessageSender {

    private JmsTemplate jmsTemplate;
    private JMSProperties properties;

    @Autowired
    public LoggingMessageSender(JmsTemplate jmsTemplate, JMSProperties properties) {
        this.jmsTemplate = jmsTemplate;
        this.properties = properties;
    }

    public void sendLoggingMessage(String message) {
        this.jmsTemplate.convertAndSend(properties.getLoggingQueue(), message);
    }
}
