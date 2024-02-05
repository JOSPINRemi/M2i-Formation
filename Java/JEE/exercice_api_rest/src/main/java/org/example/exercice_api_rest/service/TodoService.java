package org.example.exercice_api_rest.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.example.exercice_api_rest.dto.TodoDto;
import org.example.exercice_api_rest.entity.Todo;
import org.example.exercice_api_rest.repository.TodoRepository;
import org.example.exercice_api_rest.utils.HibernateSession;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class TodoService {
    private final TodoRepository todoRepository;

    @Inject
    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public TodoDto createTodo(TodoDto todoDto) {
        Todo todo = todoDto.toEntity();
        Session session = HibernateSession.getSessionFactory().openSession();
        todoRepository.setSession(session);
        session.beginTransaction();
        try {
            todoRepository.create(todo);
            session.getTransaction().commit();
            return todo.toDto();
        } catch (Exception ex) {
            session.getTransaction().rollback();
            throw ex;
        } finally {
            session.close();
        }
    }

    public List<String> getTodos() {
        Session session = HibernateSession.getSessionFactory().openSession();
        todoRepository.setSession(session);
        List<Todo> todos = todoRepository.findAll();
        List<String> todosContent = new ArrayList<>();
        for (Todo todo : todos) {
            todosContent.add(todo.getContent());
        }
        session.close();
        return todosContent;
    }

    public String getTodo(Long id) {
        Session session = HibernateSession.getSessionFactory().openSession();
        todoRepository.setSession(session);
        session.close();
        return todoRepository.findById(id).getContent();
    }

    public String updateTodo(Long id) {
        Session session = HibernateSession.getSessionFactory().openSession();
        todoRepository.setSession(session);
        session.beginTransaction();
        try {
            Todo todo = todoRepository.findById(id);
            todoRepository.update(todo);
            session.getTransaction().commit();
            return todo.getContent();
        } catch (Exception e) {
            session.getTransaction().rollback();
            throw e;
        } finally {
            session.close();
        }

    }

    public String delete(Long id) {
        Session session = HibernateSession.getSessionFactory().openSession();
        todoRepository.setSession(session);
        session.beginTransaction();
        try {
            Todo todo = todoRepository.findById(id);
            todoRepository.delete(todo);
            session.getTransaction().commit();
            return todo.getContent();
        } catch (Exception e) {
            session.getTransaction().rollback();
            throw e;
        } finally {
            session.close();
        }

    }
}
