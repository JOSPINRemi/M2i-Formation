package org.example.demo_api_rest.service;

import org.example.demo_api_rest.entity.Person;

public interface PersonService {
    Person save(String firstname, String lastname);
}
