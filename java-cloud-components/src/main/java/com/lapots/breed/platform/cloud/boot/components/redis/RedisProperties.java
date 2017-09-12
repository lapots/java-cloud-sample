package com.lapots.breed.platform.cloud.boot.components.redis;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
//@Component // but why???
//@ConfigurationProperties(prefix="java.cloud.redis")
public class RedisProperties {
    private String topic;
}
