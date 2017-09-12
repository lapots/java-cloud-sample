package com.lapots.breed.platform.cloud.boot.service.api;

import com.lapots.breed.platform.cloud.boot.domain.Person;

public interface IPersonService {
    Person findPerson(String id);

    Person generatePerson();

    void savePerson(Person p);
}
