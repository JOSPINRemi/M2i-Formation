package org.example.repository;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.Session;

import java.util.List;

@NoArgsConstructor
@Setter
@Getter
public abstract class BaseEntityRepository<T> {
    protected Session session;

    public void create(T element) {
        session.persist(element);
    }

    public void delete(T element) {
        session.remove(element);
    }

    public void update(T element) {
        session.persist(element);
    }

    abstract T findById(Long id);
    abstract List<T> findAll();
}
