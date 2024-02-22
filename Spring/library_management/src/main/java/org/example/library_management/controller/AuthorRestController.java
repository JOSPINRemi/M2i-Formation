package org.example.library_management.controller;

import lombok.RequiredArgsConstructor;
import org.example.library_management.entity.Author;
import org.example.library_management.entity.Book;
import org.example.library_management.service.BookService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/authors")
@RequiredArgsConstructor
public class AuthorRestController {
    private final BookService bookService;

    @PostMapping()
    public Author createAuthor(@RequestBody Author author) {
        return bookService.createAuthor(author);
    }
}
