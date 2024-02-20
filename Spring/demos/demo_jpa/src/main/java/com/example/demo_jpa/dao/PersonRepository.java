package com.example.demo_jpa.dao;

import com.example.demo_jpa.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Integer> {
    Person findByIdIs(Integer id);
}
