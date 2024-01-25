package org.example.tpjee_hopital.interfaces;

import java.util.List;

public interface Repository<T> {
    boolean createOrUpdate(T o);
    List<T> findAll();
    T findById(Long id);
    boolean delete(T o);

}
