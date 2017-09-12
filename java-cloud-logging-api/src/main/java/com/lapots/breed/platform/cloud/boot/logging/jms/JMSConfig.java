package com.lapots.breed.platform.cloud.boot.logging.jms;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.listener.DefaultMessageListenerContainer;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.MessageType;

import javax.jms.ConnectionFactory;
import javax.jms.MessageListener;

@Configuration
@EnableConfigurationProperties(JMSProperties.class)
public class JMSConfig {

    @Bean
    public MessageConverter jacksonJmsMessageConverter() {
        MappingJackson2MessageConverter converter = new MappingJackson2MessageConverter();
        converter.setTargetType(MessageType.TEXT);
        converter.setTypeIdPropertyName("_class_");
        return converter;
    }

    @Bean
    public DefaultMessageListenerContainer customMessageListenerContainer(ConnectionFactory connectionFactory,
                                                                          MessageListener queueListener,
                                                                          JMSProperties properties) {
        DefaultMessageListenerContainer listenerContainer = new DefaultMessageListenerContainer();
        listenerContainer.setConnectionFactory(connectionFactory);
        listenerContainer.setDestinationName(properties.getLoggingQueue());
        listenerContainer.setMessageListener(queueListener);
        return listenerContainer;
    }
}
