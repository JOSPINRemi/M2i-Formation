package org.example.demo_r2dbc.repository;

import org.example.demo_r2dbc.entity.Person;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface PersonRepository extends R2dbcRepository<Person, Integer> {

    Flux<Person> searchAllByFirstNameContainingIgnoreCase(String firstName);

    @Query("SELECT id, last_name, first_name FROM Person WHERE first_name LIKE :search")
    Flux<Person> customSearch(String search);
}
