package com.lapots.breed.platform.cloud.boot.aop;

import com.lapots.breed.platform.cloud.boot.devtools.JavaLogUtils;
import com.lapots.breed.platform.cloud.boot.logging.jms.JMSProperties;
import com.lapots.breed.platform.cloud.boot.logging.jms.LoggingMessageSender;
import com.lapots.breed.platform.cloud.boot.logging.aop.LoggingAspect;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

public class ApplicationLoggingAspect extends LoggingAspect {
    private static final Logger LOGGER = JavaLogUtils.getLogger();
    private JMSProperties properties;
    private LoggingMessageSender loggingMessageSender;

    @Autowired
    public ApplicationLoggingAspect(JMSProperties properties, LoggingMessageSender loggingMessageSender) {
        this.loggingMessageSender = loggingMessageSender;
        this.properties = properties;
    }

    @Override
    @Before("execution(* com.lapots.breed.platform.cloud.boot.listener.application.CloudRestApiListener.*(..))")
    public void log(JoinPoint jp) {
        LOGGER.info("Send logging message!");
        String message = "Invoking method: " + jp.getSignature().getName();
        loggingMessageSender.sendLoggingMessage(message);
    }
}
