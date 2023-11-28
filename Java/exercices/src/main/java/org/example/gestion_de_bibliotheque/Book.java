package org.example.gestion_de_bibliotheque;

// FIXME: 28/11/2023 Make class abstract
public class Book {
    private static int counter = 0;
    // FIXME: 28/11/2023 Make id integer
    private String id;
    private String title;
    public String author;

    public Book(String title, String author) {
        this.id = String.valueOf(++counter);
        this.title = title;
        this.author = author;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}
