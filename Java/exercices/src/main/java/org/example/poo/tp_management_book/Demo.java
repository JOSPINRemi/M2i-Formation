package org.example.poo.tp_management_book;

import java.math.BigDecimal;

public class Demo {
    public static void main(String[] args) {
        Book[] books = new Book[]{
                new Book(1,
                        "Book_1",
                        new Author[]{new Author(1, "Jon", "Johnson")},
                        new Publisher(1, "Publisher_1"),
                        1990,
                        231,
                        BigDecimal.valueOf(24.99),
                        CoverType.PAPERBACK),
                new Book(2,
                        "Book_2",
                        new Author[]{new Author(1, "Jon", "Johnson"), new Author(2, "William", "Wilson")},
                        new Publisher(2, "Publisher_2 "),
                        2000,
                        120,
                        BigDecimal.valueOf(14.99),
                        CoverType.PAPERBACK),
                new Book(3,
                        "Book_3",
                        new Author[]{new Author(3, "Walter", "Peterson")},
                        new Publisher(1, "Publisher_1"),
                        1997,
                        350,
                        BigDecimal.valueOf(34.99),
                        CoverType.HARDCOUVERTURE),
                new Book(4,
                        "Book_4",
                        new Author[]{new Author(4, "Craig", "Gregory")},
                        new Publisher(3, "Publisher_3"),
                        1992,
                        185,
                        BigDecimal.valueOf(19.99),
                        CoverType.PAPERBACK)
        };

        BookService bookService = new BookService();
        Book[] booksByAuthor = bookService.filterBooksByAuthor(new Author(1, "Jon", "Johnson"), books);
        System.out.println("Books filtered by author :");
        for (Book b : booksByAuthor) {
            System.out.println(b);
        }
        Book[] booksByPublisher = bookService.filterBooksByPublisher(new Publisher(1, "Publisher_1"), books);
        System.out.println("Books filtered by publisher :");
        for (Book b : booksByPublisher) {
            System.out.println(b);
        }
        Book[] booksAfterSpecifiedYear = bookService.filterBooksAfterSpecifiedYear(1997, books);
        System.out.println("Books After :");
        for (Book b : booksAfterSpecifiedYear) {
            System.out.println(b);
        }
    }
}
