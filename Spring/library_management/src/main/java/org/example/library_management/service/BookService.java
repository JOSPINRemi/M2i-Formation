package org.example.library_management.service;

import lombok.RequiredArgsConstructor;
import org.example.library_management.annotation.LoggingAnnotation;
import org.example.library_management.annotation.PerformanceAnnotation;
import org.example.library_management.entity.Author;
import org.example.library_management.entity.Book;
import org.example.library_management.repository.AuthorRepository;
import org.example.library_management.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

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

    public Author createAuthor(Author author) {
        return authorRepository.save(author);
    }

    public Book findById(Long id) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        if(optionalBook.isPresent()){
            return optionalBook.get();
        }
        throw new RuntimeException("Not found");
    }
}
