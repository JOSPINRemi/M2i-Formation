package org.example.exercice_api_rest.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.example.exercice_api_rest.dto.TodoDto;
import org.example.exercice_api_rest.entity.Todo;
import org.example.exercice_api_rest.repository.TodoRepository;
import org.example.exercice_api_rest.utils.HibernateSession;
import org.hibernate.Session;

import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class TodoService {
    private final TodoRepository todoRepository;

    @Inject
    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public TodoDto createTodo(TodoDto todoDto) {
        Session session = HibernateSession.getSessionFactory().openSession();
        session.beginTransaction();
        try (session) {
            todoRepository.setSession(session);
            Todo todo = todoDto.toEntity();
            todoRepository.create(todo);
            session.getTransaction().commit();
            return todo.toDto();
        } catch (Exception ex) {
            session.getTransaction().rollback();
            throw ex;
        }
    }

    public List<TodoDto> getTodos() {
        Session session = HibernateSession.getSessionFactory().openSession();
        try (session) {
            todoRepository.setSession(session);
            return todoRepository.findAll()
                    .stream().map(Todo::toDto)
                    .collect(Collectors.toList());
        }
    }

    public TodoDto getTodo(Long id) {
        Session session = HibernateSession.getSessionFactory().openSession();
        try (session) {
            todoRepository.setSession(session);
            Todo todo = todoRepository.findById(id);
            return todo.toDto();
        }
    }

    public TodoDto changeStatus(Long id) {
        Session session = HibernateSession.getSessionFactory().openSession();
        session.beginTransaction();
        try (session) {
            todoRepository.setSession(session);
            Todo todo = todoRepository.findById(id);
            todo.setStatus(!todo.isStatus());
            todoRepository.update(todo);
            session.getTransaction().commit();
            return todo.toDto();
        } catch (Exception e) {
            session.getTransaction().rollback();
            throw e;
        }
    }

    public boolean delete(Long id) {
        Session session = HibernateSession.getSessionFactory().openSession();
        session.beginTransaction();
        try (session) {
            todoRepository.setSession(session);
            Todo todo = todoRepository.findById(id);
            todoRepository.delete(todo);
            session.getTransaction().commit();
            return true;
        } catch (Exception e) {
            session.getTransaction().rollback();
            throw e;
        }
    }
}
