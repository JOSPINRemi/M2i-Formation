package org.example.repository;

import org.example.entity.BookEntity;

import java.util.List;

public class BookEntityRepository extends BaseEntityRepository<BookEntity> {
    @Override
    public BookEntity findById(Long id) {
        return session.get(BookEntity.class, id);
    }

    public List<BookEntity> findAllByTitle(String key) {
        return session.createQuery("from BookEntity where title like :t", BookEntity.class)
                .setParameter("t", key)
                .list();
    }

    @Override
    public List<BookEntity> findAll() {
        return session.createQuery("from BookEntity ", BookEntity.class).list();
    }
}
