package org.example.collections.TP_Papeterie;

public abstract class Article {
    protected String reference;

    public Article(String reference) {
        this.reference = reference;
    }

    public String getReference() {
        return reference;
    }
}
