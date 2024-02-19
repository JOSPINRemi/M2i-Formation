package com.example.demo_jpa.controller;

import com.example.demo_jpa.entity.Person;
import com.example.demo_jpa.service.PersonService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class PersonRestController {
    private PersonService personService;

    /*@GetMapping("/addoneperson")
    public void addOnePerson() {
        personService.save(Person.builder()
                .firstName("toto")
                .lastName("tata")
                .email("toto@tata.com")
                .build());
    }*/

    @PostMapping("/add")
    public Person addPerson(@RequestBody Person person) {
        return personService.save(person);
    }

    @GetMapping("/list")
    public List<Person> getAllPersons() {
        return personService.findAll();
    }

    @GetMapping("/details/{id}")
    public Person getPersonById(@PathVariable int id) {
        return personService.findById(id);
    }

    @PutMapping("/update")
    public Person updatePerson(@RequestBody Person person) {
        return personService.update(person);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteOnePerson(@PathVariable int id) {
        personService.delete(id);
    }
}