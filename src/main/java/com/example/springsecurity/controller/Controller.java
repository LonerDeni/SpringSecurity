package com.example.springsecurity.controller;


import com.example.springsecurity.model.Persons;
import com.example.springsecurity.repository.PersonRepository;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.RolesAllowed;
import java.util.List;
import java.util.Optional;


@RestController
public class Controller {

    private final PersonRepository personRepository;

    public Controller(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @GetMapping("/persons/by-city")
    @Secured("ROLE_READ")
    public List<Persons> getCity(@RequestParam @RequestBody String city) {
        return personRepository.getPersonsByCity(city);
    }
    @GetMapping("/persons/by-age")
    @RolesAllowed("ROLE_WRITE")
    public List<Persons> getAge(@RequestParam @RequestBody int age) {
        return personRepository.getPersonsAge(age);
    }
    @GetMapping("/persons/by-fullName")
    @PreAuthorize("hasAnyRole('ROLE_WRITE','ROLE_READ')")
    public Optional<Persons> getNameAndSurname(@RequestParam @RequestBody String name, @RequestParam @RequestBody String surName) {
        return personRepository.getPersonsFullName(name, surName);
    }
    @GetMapping("/persons/auth")
    public String getAuthSucces() {
        return "Authorization Successful";
    }
    @GetMapping("/persons/by-name")
    @PreAuthorize("#username == authentication.principal.username")
    public String getName(@RequestParam String username) {
        return String.format("Authorization Successful %s",username);
    }
}