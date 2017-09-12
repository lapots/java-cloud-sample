package com.lapots.breed.platform.cloud.boot.service;

import com.lapots.breed.platform.cloud.boot.domain.Person;
import com.lapots.breed.platform.cloud.boot.exception.ApplicationException;
import com.lapots.breed.platform.cloud.boot.repository.PersonRepository;
import com.lapots.breed.platform.cloud.boot.service.api.IPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@Transactional
public class PersonService implements IPersonService {

    @Autowired
    private PersonRepository personRepository;

    @Override
    public Person findPerson(String id) {
        // return personRepository.findOne(UUID.fromString(id));
        throw new ApplicationException("JPA", null);
    }

    @Override
    public Person generatePerson() {
        Person person = new Person();
        person.setId(UUID.randomUUID());
        person.setName("Nike");
        return person;
    }

    @Override
    public void savePerson(Person p) {
        personRepository.save(p);
    }
}
