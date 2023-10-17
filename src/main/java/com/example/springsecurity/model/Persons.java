package com.example.springsecurity.model;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Data
@Getter
@Setter
@NoArgsConstructor
@Table(schema = "netology")
@IdClass(PersonsDateId.class)
public class Persons {
    @Id
    @Column(nullable = false)
    private String name;

    @Id
    @Column(name = "surname",nullable = false)
    private String surName;

    @Id
    @Column(nullable = false)
    private int age;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "city_of_living")
    private String cityOfLiving;
}