package com.example.springsecurity.repository;

import com.example.springsecurity.model.Persons;
import com.example.springsecurity.repositories.PersonRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class PersonRepository {

    private final PersonRepositories personRepositories;

    public PersonRepository(PersonRepositories personRepositories) {
        this.personRepositories = personRepositories;
    }

    public List<Persons> getPersonsByCity(String city) {
        return personRepositories.findByCityOfLiving(city);
    }
    public List<Persons> getPersonsAge(int age) {
        return personRepositories.findByAgeLessThanOrderByAgeAsc(age);
    }
    public Optional<Persons> getPersonsFullName(String name, String surname) {
        return personRepositories.findByNameIgnoreCaseAndSurNameIgnoreCase(name,surname);
    }
}