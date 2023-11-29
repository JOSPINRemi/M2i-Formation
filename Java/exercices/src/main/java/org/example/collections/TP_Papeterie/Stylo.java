package org.example.collections.TP_Papeterie;

public class Stylo extends ArticleUnitaire {
    private String couleur;

    public Stylo(String reference, String nom, double prixUnitaire, String couleur) {
        super(reference, nom, prixUnitaire);
        this.couleur = couleur;
    }

    public Stylo(String reference, String nom, double prixUnitaire) {
        this(reference, nom, prixUnitaire, "bleu");
    }

    public Stylo(String reference, String nom) {
        this(reference, nom, 1.5);
    }
}
