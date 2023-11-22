package org.example.poo.tp_class;

public class Chaise {
    private int nbPieds;
    private String couleur;
    private String matériaux;

    public Chaise() {
    }

    public Chaise(int nbPieds, String couleur, String matériaux) {
        this.nbPieds = nbPieds;
        this.couleur = couleur;
        this.matériaux = matériaux;
    }

    public int getNbPieds() {
        return nbPieds;
    }

    public String getCouleur() {
        return couleur;
    }

    public String getMatériaux() {
        return matériaux;
    }
}
