package com.example.demo_jpa.service;

import com.example.demo_jpa.dao.PersonRepository;
import com.example.demo_jpa.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonServiceImpl implements PersonService {
    private PersonRepository personRepository;

    @Autowired
    public PersonServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public Person save(Person person) {
        return personRepository.save(person);
    }

    @Override
    public List<Person> findAll() {
        return personRepository.findAll();
    }

    @Override
    public Person findById(int id) {
//        return personRepository.findByIdIs(id);
        Optional<Person> result = personRepository.findById(id);
        return result.orElse(null);
    }

    @Override
    public Person update(Person person) {
        return personRepository.save(person);
    }

    @Override
    public void delete(int id) {
        if (personRepository.findById(id).isPresent()) {
            personRepository.deleteById(id);
        }
    }
}
