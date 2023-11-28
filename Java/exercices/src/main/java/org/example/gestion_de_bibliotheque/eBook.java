package org.example.gestion_de_bibliotheque;

public class eBook extends Book {
    private String format;
    private int size;

    public eBook(String title, String author, String format, int size) {
        super(title, author);
        this.format = format;
        this.size = size;
    }

    @Override
    public String toString() {
        return "eBook{" +
                "format='" + format + '\'' +
                ", size=" + size +
                ", author='" + author + '\'' +
                '}';
    }
}
