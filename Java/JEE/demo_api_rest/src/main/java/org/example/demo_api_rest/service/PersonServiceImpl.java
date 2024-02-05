package org.example.demo_api_rest.service;

import jakarta.enterprise.context.ApplicationScoped;
import org.example.demo_api_rest.entity.Person;

@ApplicationScoped
public class PersonServiceImpl implements PersonService {

    public Person save(String firstname, String lastname) {
        return new Person(firstname, lastname);
    }
}
