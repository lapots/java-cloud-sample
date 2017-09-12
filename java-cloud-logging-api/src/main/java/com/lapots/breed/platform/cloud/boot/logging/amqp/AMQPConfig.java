package com.lapots.breed.platform.cloud.boot.logging.amqp;

import com.rabbitmq.client.BlockedListener;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

// @Configuration
@EnableConfigurationProperties(AMQPProperties.class)
public class AMQPConfig {
    @Bean
    public Queue queue(AMQPProperties properties) {
        return new Queue(properties.getLoggingQueue(), false);
    }

    @Bean
    public Exchange exchange(AMQPProperties properties) {
        return new DirectExchange(properties.getLoggingExchange());
    }

    @Bean
    public SimpleMessageListenerContainer container(ConnectionFactory connectionFactory,
                                                    @Qualifier("amqpQueueListener") MessageListener consumer,
                                                    AMQPProperties properties) {
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        container.setQueueNames(properties.getLoggingQueue());
        container.setMessageListener(consumer);
        return container;
    }

    @Bean
    public Binding binding(AMQPProperties properties) {
        return new Binding(
                properties.getLoggingQueue(),
                Binding.DestinationType.QUEUE, properties.getLoggingExchange(),
                properties.getLoggingQueue(),
                null
        );
    }

    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
        RabbitTemplate template = new RabbitTemplate(connectionFactory);
        template.execute(channel -> {
            channel.getConnection().addBlockedListener(new BlockedListener() {
                @Override
                public void handleBlocked(String s) throws IOException {

                }

                @Override
                public void handleUnblocked() throws IOException {

                }
            });
            channel.getConnection().addShutdownListener(e -> {

            });
            return null;
        });
        return template;
    }
}
