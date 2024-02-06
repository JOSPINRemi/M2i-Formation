package org.example.port;

import org.example.entity.Book;

import java.util.List;

public interface BookRepository {
    void create(Book book);
    List<Book> search(String title);
    Book findById(Long id);
    void delete(Book book);

}
