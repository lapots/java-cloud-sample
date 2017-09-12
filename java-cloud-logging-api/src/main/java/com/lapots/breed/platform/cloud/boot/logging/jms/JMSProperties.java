package com.lapots.breed.platform.cloud.boot.logging.jms;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix="java.cloud.logging")
public class JMSProperties {
    private String loggingQueue;
}
