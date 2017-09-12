package com.lapots.breed.platform.cloud.boot;

import com.lapots.breed.platform.cloud.boot.components.redis.pubsub.Publisher;
import com.lapots.breed.platform.cloud.boot.components.websocket.WebSocketHandler;
import com.lapots.breed.platform.cloud.boot.domain.Person;
import com.lapots.breed.platform.cloud.boot.logging.amqp.LoggingMessageProducer;
import com.lapots.breed.platform.cloud.boot.logging.jms.LoggingMessageSender;
import com.lapots.breed.platform.cloud.boot.repository.PersonRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketHttpHeaders;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.client.standard.StandardWebSocketClient;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.UUID;

@SpringBootApplication
@ComponentScan("com.lapots.breed.platform.cloud.boot")
@EnableJpaRepositories("com.lapots.breed.platform.cloud.boot.repository")
@EntityScan("com.lapots.breed.platform.cloud.boot.domain")
@EnableAspectJAutoProxy
@EnableJms
public class JavaCloudSampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(JavaCloudSampleApplication.class, args);
    }

    @Bean
    public CommandLineRunner data(PersonRepository repository) {
        return (args) -> {
            repository.save(new Person(UUID.randomUUID(), "Nike"));
        };
    }

    @Bean
    public CommandLineRunner welcomeActiveMqMessage(LoggingMessageSender sender) {
        return args -> {
          sender.sendLoggingMessage("Application started!");
        };
    }

    // @Bean // active on rabbitmq existence only
    public CommandLineRunner welcomeRabbitMqMessage(LoggingMessageProducer producer) {
        return args -> {
            producer.sendLoggingMessage("Application started!");
        };
    }

    //@Bean
    public CommandLineRunner welcomeRedisMessage(Publisher publisher) {
        return args -> {
            publisher.publish("Application started!");
        };
    }

    @Bean
    public CommandLineRunner welcomeSocketMessage(WebSocketHandler handler) throws URISyntaxException {
        return args -> {
            StandardWebSocketClient client = new StandardWebSocketClient();
            ListenableFuture<WebSocketSession> future = client.doHandshake(handler,
                    new WebSocketHttpHeaders(),
                    new URI("ws://localhost:8080/ws"));
            WebSocketSession session = future.get();
            WebSocketMessage<String> message = new TextMessage("Hello from Spring");
            session.sendMessage(message);
        };
    }
}
