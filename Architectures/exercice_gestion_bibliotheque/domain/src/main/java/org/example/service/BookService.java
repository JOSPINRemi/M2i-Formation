package org.example.service;

import org.example.entity.Book;
import org.example.port.BookRepository;

import java.util.List;

public class BookService {
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Book createBook(String title, String author) {
        if (title.length() < 3) {
            throw new RuntimeException("Title length must be gt 3 char");
        }
        Book book = new Book(title, author);
        bookRepository.create(book);
        return book;
    }

    public List<Book> searchBook(String title) {
        if (title.length() < 3) {
            throw new RuntimeException("Title length must be gt 3 char");
        }
        return bookRepository.search(title);
    }

    public void deleteBook(Long id) {
        Book book = bookRepository.findById(id);
        if (book != null) {
            bookRepository.delete(book);
        }
        throw new RuntimeException("Book not found");
    }
}
