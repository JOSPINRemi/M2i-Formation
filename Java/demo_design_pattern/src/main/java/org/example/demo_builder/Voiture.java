package org.example.demo_builder;

public class Voiture {
    private String marque;
    private String modele;
    private int annee;
    private double prix;

    public Voiture(Builder builder) {
        this.marque = builder.marque;
        this.modele = builder.modele;
        this.annee = builder.annee;
        this.prix = builder.prix;
    }

    public static class Builder {
        private String marque;
        private String modele;
        private int annee;
        private double prix;

        public Builder marque(String marque) {
            this.marque = marque;
            return this;
        }

        public Builder modele(String modele) {
            this.modele = modele;
            return this;
        }

        public Builder annee(int annee) {
            this.annee = annee;
            return this;
        }

        public Builder prix(double prix) {
            this.prix = prix;
            return this;
        }

        public Voiture build() {
            return new Voiture(this);
        }
    }
}
