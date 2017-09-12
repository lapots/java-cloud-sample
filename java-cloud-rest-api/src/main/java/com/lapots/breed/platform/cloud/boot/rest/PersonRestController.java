package com.lapots.breed.platform.cloud.boot.rest;

import com.lapots.breed.platform.cloud.boot.domain.Person;
import com.lapots.breed.platform.cloud.boot.logging.jms.LoggingMessageSender;
import com.lapots.breed.platform.cloud.boot.service.api.IPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonRestController {

    @Autowired
    private LoggingMessageSender loggingMessageSender;

    @Autowired
    private IPersonService personService;

    @GetMapping("/rest/person/rnd")
    public Person randomPerson() {
        loggingMessageSender.sendLoggingMessage("Generating person!");
        return personService.generatePerson();
    }

    @GetMapping("/rest/person/{id}")
    public Person findPerson(@PathVariable String id) {
        return personService.findPerson(id);
    }
}
