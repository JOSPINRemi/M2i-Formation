package org.example.library_management.service;

import lombok.RequiredArgsConstructor;
import org.example.library_management.annotation.LoggingAnnotation;
import org.example.library_management.annotation.PerformanceAnnotation;
import org.example.library_management.entity.Book;
import org.example.library_management.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;

    @LoggingAnnotation
    @PerformanceAnnotation
    public Book create(Book book) {
        return bookRepository.save(book);
    }

    @LoggingAnnotation
    @PerformanceAnnotation
    public List<Book> getAll() {
        return (List<Book>) bookRepository.findAll();
    }

    @LoggingAnnotation
    @PerformanceAnnotation
    public void delete(Long id) {
        bookRepository.deleteById(id);
    }
}
