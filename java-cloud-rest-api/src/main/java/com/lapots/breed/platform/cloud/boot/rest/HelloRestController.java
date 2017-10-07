package com.lapots.breed.platform.cloud.boot.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloRestController {

    @GetMapping("/rest/hello")
    public String hello() {
        return "hello-world";
    }

}
