package org.example.repository.impl;

import org.example.entity.Book;
import org.example.entity.BookEntity;
import org.example.port.BookRepository;
import org.example.repository.BookEntityRepository;
import org.example.utils.HibernateSession;
import org.hibernate.Session;

import java.util.List;
import java.util.stream.Collectors;

public class BookRepositoryImpl implements BookRepository {
    private final BookEntityRepository bookEntityRepository;

    public BookRepositoryImpl(BookEntityRepository bookEntityRepository) {
        this.bookEntityRepository = bookEntityRepository;
    }

    @Override
    public void create(Book book) {
        Session session = HibernateSession.getSessionFactory().openSession();
        session.beginTransaction();
        try (session) {
            bookEntityRepository.setSession(session);
            BookEntity bookEntity = BookEntity.builder()
                    .title(book.getTitle())
                    .author(book.getAuthor())
                    .build();
            bookEntityRepository.create(bookEntity);
            book.setId(book.getId());
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            throw e;
        }
    }

    @Override
    public Book findById(Long id) {
        Session session = HibernateSession.getSessionFactory().openSession();
        try (session) {
            bookEntityRepository.setSession(session);
            BookEntity bookEntity = bookEntityRepository.findById(id);
            return bookEntity.toBook();
        }
    }

    @Override
    public List<Book> search(String title) {
        Session session = HibernateSession.getSessionFactory().openSession();
        try (session) {
            return bookEntityRepository.findByTitle(title)
                    .stream().map(BookEntity::toBook)
                    .collect(Collectors.toList());
        }
    }

    @Override
    public void delete(Book book) {
        Session session = HibernateSession.getSessionFactory().openSession();
        session.beginTransaction();
        try (session) {
            bookEntityRepository.setSession(session);
            BookEntity bookEntity = bookEntityRepository.findById(book.getId());
            bookEntityRepository.delete(bookEntity);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            throw e;
        }
    }
}
