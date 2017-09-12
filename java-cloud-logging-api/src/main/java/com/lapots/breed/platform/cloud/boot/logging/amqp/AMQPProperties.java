package com.lapots.breed.platform.cloud.boot.logging.amqp;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix="java.cloud.logging")
public class AMQPProperties {
    private String loggingQueue;
    private String loggingExchange;
}
