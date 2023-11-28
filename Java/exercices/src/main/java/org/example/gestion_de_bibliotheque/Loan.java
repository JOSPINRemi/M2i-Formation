package org.example.gestion_de_bibliotheque;

import java.time.LocalDate;

public class Loan {
    private Person person;
    private Book book;
    private LocalDate start;
    private LocalDate end;

    public Loan(Person person, Book book, LocalDate start, LocalDate end) {
        this.person = person;
        this.book = book;
        this.start = start;
        this.end = end;
    }

    public Book getBook() {
        return book;
    }

    public LocalDate getEnd() {
        return end;
    }

    public void setEnd(LocalDate end) {
        this.end = end;
    }

    @Override
    public String toString() {
        return "Loan{" +
                "person=" + person +
                ", book=" + book +
                ", start=" + start +
                ", end=" + end +
                '}';
    }
}
