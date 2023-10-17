package com.example.springsecurity.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@AllArgsConstructor
@Data
@Getter
@NoArgsConstructor
public class PersonsDateId implements Serializable {
    private String name;
    private String surName;
    private int age;
}
