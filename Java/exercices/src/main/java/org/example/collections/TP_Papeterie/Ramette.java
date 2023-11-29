package org.example.collections.TP_Papeterie;

public class Ramette extends ArticleUnitaire {
    private double grammage;

    public Ramette(String reference, String nom, double prixUnitaire, double grammage) {
        super(reference, nom, prixUnitaire);
        this.grammage = grammage;
    }
}
