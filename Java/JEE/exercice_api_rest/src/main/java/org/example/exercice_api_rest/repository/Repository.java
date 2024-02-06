package org.example.exercice_api_rest.repository;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.Session;

import java.util.List;

@NoArgsConstructor
@Setter
@Getter
public abstract class Repository<T> {
    protected Session session;

    public void create(T elment) {
        this.session.persist(elment);
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
