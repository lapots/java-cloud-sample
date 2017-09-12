package com.lapots.breed.platform.cloud.boot.components.redis.pubsub;

import com.lapots.breed.platform.cloud.boot.components.redis.RedisProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

//@Component
public class Publisher {

    private RedisTemplate redisTemplate;
    private RedisProperties redisProperties;

    @Autowired
    public Publisher(RedisTemplate redisTemplate, RedisProperties redisProperties) {
        this.redisTemplate = redisTemplate;
        this.redisProperties = redisProperties;
    }

    public void publish(String message) {
        redisTemplate.convertAndSend(redisProperties.getTopic(), message);
    }
}
