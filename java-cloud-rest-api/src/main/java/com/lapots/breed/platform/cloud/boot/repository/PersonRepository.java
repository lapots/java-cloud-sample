package com.lapots.breed.platform.cloud.boot.repository;

import com.lapots.breed.platform.cloud.boot.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PersonRepository extends JpaRepository<Person, UUID> {
}
