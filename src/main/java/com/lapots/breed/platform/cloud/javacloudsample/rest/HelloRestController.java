package com.lapots.breed.platform.cloud.javacloudsample.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloRestController {

    @RequestMapping("/rest/hello")
    public String hello() {
        return "hello-world";
    }

}
