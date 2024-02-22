package org.example.library_management.controller;

import lombok.RequiredArgsConstructor;
import org.example.library_management.entity.Book;
import org.example.library_management.service.BookService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookRestController {
    private final BookService bookService;

    @PostMapping()
    public Book createBook(@RequestBody Book book) {
        return bookService.create(book);
    }

    @GetMapping()
    public List<Book> getAllBooks() {
        return bookService.getAll();
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Long id) {
        bookService.delete(id);
    }
}
