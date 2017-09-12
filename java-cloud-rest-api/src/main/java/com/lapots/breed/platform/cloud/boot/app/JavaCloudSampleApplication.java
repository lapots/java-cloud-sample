package com.lapots.breed.platform.cloud.boot.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.lapots.breed.platform.cloud.boot")
public class JavaCloudSampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(JavaCloudSampleApplication.class, args);
    }
}
