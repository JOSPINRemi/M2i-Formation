package org.example.collections.TP_Papeterie;

public abstract class ArticleUnitaire extends Article {
    protected String nom;
    protected double prixUnitaire;

    public ArticleUnitaire(String reference, String nom, double prixUnitaire) {
        super(reference);
        this.nom = nom;
        this.prixUnitaire = prixUnitaire;
    }

    public String getNom() {
        return nom;
    }

    public double getPrixUnitaire() {
        return prixUnitaire;
    }
}
