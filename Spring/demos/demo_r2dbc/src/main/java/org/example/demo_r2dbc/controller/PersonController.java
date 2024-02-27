package org.example.demo_r2dbc.controller;


import org.example.demo_r2dbc.dao.PersonDao;
import org.example.demo_r2dbc.entity.Person;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("person")
public class PersonController {

    private final PersonDao personDao;

    public PersonController(PersonDao personDao) {
        this.personDao = personDao;
    }

    @PostMapping
    public Mono post(@RequestBody Person person) {
        return personDao.add(person.getLastName(), person.getFirstName());
    }

    @GetMapping(produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Person> get() {
        return personDao.getAll();
    }

    @PutMapping("{id}")
    public Mono<Long> put(@PathVariable int id, @RequestBody Person person) {
        return personDao.update(id, person.getLastName(), person.getFirstName());
    }

    @DeleteMapping("{id}")
    public Mono delete(@PathVariable int id) {
        return personDao.delete(id);
    }
}
