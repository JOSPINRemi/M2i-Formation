package org.example.collections.TP_Papeterie;

public class Lot extends Article {
    private Article article;
    private int quantite;
    private double pourcentageRemise;

    public Lot(String reference, int quantite, int pourcentageRemise) {
        super(reference);
        this.article = BDD.articles.get(reference);
        this.quantite = quantite;
        this.pourcentageRemise = (double) pourcentageRemise / 100;
    }

    public Article getArticle() {
        return article;
    }

    public int getQuantite() {
        return quantite;
    }

    public double getPourcentageRemise() {
        return pourcentageRemise;
    }
}
