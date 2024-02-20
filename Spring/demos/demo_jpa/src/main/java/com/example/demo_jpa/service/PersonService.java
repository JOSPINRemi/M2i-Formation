package com.example.demo_jpa.service;

import com.example.demo_jpa.entity.Person;

import java.util.List;

public interface PersonService {
    Person save(Person person);

    List<Person> findAll();

    Person findById(int id);

    Person update(Person person);

    void delete(int id);
}
