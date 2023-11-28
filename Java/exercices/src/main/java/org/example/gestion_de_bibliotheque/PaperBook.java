package org.example.gestion_de_bibliotheque;

public class PaperBook extends Book {
    private int amountOfPages;
    private String publisher;

    public PaperBook(String title, String author, int amountOfPages, String publisher) {
        super(title, author);
        this.amountOfPages = amountOfPages;
        this.publisher = publisher;
    }

    @Override
    public String toString() {
        return "PaperBook{" +
                "amountOfPages=" + amountOfPages +
                ", publisher='" + publisher + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}
