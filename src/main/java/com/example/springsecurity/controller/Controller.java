package com.example.springsecurity.controller;


import com.example.springsecurity.model.Persons;
import com.example.springsecurity.repository.PersonRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;


@RestController
public class Controller {

    private final PersonRepository personRepository;

    public Controller(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @GetMapping("/persons/by-city")
    public List<Persons> getCity(@RequestParam @RequestBody String city) {
        return personRepository.getPersonsByCity(city);
    }
    @GetMapping("/persons/by-age")
    public List<Persons> getAge(@RequestParam @RequestBody int age) {
        return personRepository.getPersonsAge(age);
    }
    @GetMapping("/persons/by-fullName")
    public Optional<Persons> getNameAndSurname(@RequestParam @RequestBody String name, @RequestParam @RequestBody String surName) {
        return personRepository.getPersonsFullName(name, surName);
    }
    @GetMapping("/persons/auth")
    public String getAuthSucces() {
        return "Authorization Successful";
    }
}