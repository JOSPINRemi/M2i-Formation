package org.example.exercice_api_rest.repository;

import jakarta.enterprise.context.ApplicationScoped;
import org.example.exercice_api_rest.entity.Todo;

import java.util.List;

@ApplicationScoped
public class TodoRepository extends Repository<Todo> {
    @Override
    public Todo findById(Long id) {
        return session.get(Todo.class, id);
    }

    @Override
    public List<Todo> findAll() {
        return session.createQuery("from Todo ").list();
    }
}
