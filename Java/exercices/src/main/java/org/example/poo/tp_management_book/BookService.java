package org.example.poo.tp_management_book;

import java.util.ArrayList;
import java.util.List;

public class BookService {
    public Book[] filterBooksByAuthor(Author author, Book[] books) {
        List<Book> filtredBooks = new ArrayList<>();
        for (Book b : books) {
            for (Author a : b.getAuthors()) {
                if (author.getId() == a.getId()) {
                    filtredBooks.add(b);
                    break;
                }
            }
        }
        return filtredBooks.toArray(new Book[0]);
    }

    public Book[] filterBooksByPublisher(Publisher publisher, Book[] books) {
        List<Book> filtredBooks = new ArrayList<>();
        for (Book b : books) {
            if (b.getPublisher().getId() == publisher.getId()) {
                filtredBooks.add(b);
                break;
            }

        }
        return filtredBooks.toArray(new Book[0]);
    }

    public Book[] filterBooksAfterSpecifiedYear(int yearFromInclusively, Book[] books) {
        List<Book> filtredBooks = new ArrayList<>();
        for (Book b : books) {
            if (b.getPublishingYear() >= yearFromInclusively) {
                filtredBooks.add(b);
                break;
            }

        }
        return filtredBooks.toArray(new Book[0]);
    }
}
