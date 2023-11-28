package org.example.gestion_de_bibliotheque;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> books;
    private List<Loan> loans;

    public Library() {
        books = new ArrayList<>();
        loans = new ArrayList<>();
    }

    public List<Book> getBooks() {
        return books;
    }

    public List<Loan> getLoans() {
        return loans;
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public boolean removeBook(String idBook) {
        for (Book book : books) {
            if (book.getId().equals(idBook)) {
                books.remove(book);
                return true;
            }
        }
        return false;
    }

    public List<Book> findBooksByTitle(String title) {
        List<Book> foundBooks = new ArrayList<>();
        for (Book book : books) {
            if (book.getTitle().equals(title)) {
                foundBooks.add(book);
            }
        }
        return foundBooks;
    }

    public List<Book> findBooksByAuthor(String author) {
        List<Book> foundBooks = new ArrayList<>();
        for (Book book : books) {
            if (book.getAuthor().equals(author)) {
                foundBooks.add(book);
            }
        }
        return foundBooks;
    }

    public boolean borrowBook(String idBook, Person person) {
        boolean isBorrowedBook = false;
        for (Book book : books) {
            if (book.getId().equals(idBook)) {
                for (Loan loan : loans) {
                    if (loan.getBook().getId().equals(idBook) && loan.getEnd() == null) {
                        isBorrowedBook = true;
                        break;
                    }
                }
                if (!isBorrowedBook) {
                    loans.add(new Loan(person, book, LocalDate.now(), null));
                }
                break;
            }
        }
        return !isBorrowedBook;
    }

    public void returnBorrowedBook(String idBook) {
        for (Loan loan : loans) {
            if (loan.getBook().getId().equals(idBook)) {
                loan.setEnd(LocalDate.now());
            }
        }
    }

}
