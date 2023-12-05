package org.example.exercice_builder;

import java.util.List;

public class Pizza {
    private String taille;
    private String typeDePate;
    private String fromage;
    private List<String> garnitures;
    private String typeDeSauce;

    private Pizza(Builder builder) {
        this.taille = builder.taille;
        this.typeDePate = builder.typeDePate;
        this.fromage = builder.fromage;
        this.garnitures = builder.garnitures;
        this.typeDeSauce = builder.typeDeSauce;
    }

    @Override
    public String toString() {
        return "Pizza{" +
                "taille='" + taille + '\'' +
                ", typeDePate='" + typeDePate + '\'' +
                ", fromage='" + fromage + '\'' +
                ", garnitures=" + garnitures +
                ", sauce='" + typeDeSauce + '\'' +
                '}';
    }

    public void ajouterGarniture(String garniture){
        this.garnitures.add(garniture);
    }

    public static class Builder {
        private String taille;
        private String typeDePate;
        private String fromage;
        private List<String> garnitures;
        private String typeDeSauce;

        public Builder taille(String taille) {
            this.taille = taille;
            return this;
        }

        public Builder typeDePate(String typeDePate) {
            this.typeDePate = typeDePate;
            return this;
        }

        public Builder fromage(String fromage) {
            if (this.fromage != null){
                throw new RuntimeException("Un fromage a déjà été choisi");
            }
            this.fromage = fromage;
            return this;
        }

        public Builder garnitures(List<String> garnitures) {
            this.garnitures = garnitures;
            return this;
        }

        public Builder typeDeSauce(String typeDeSauce) {
            this.typeDeSauce = typeDeSauce;
            return this;
        }

        public Pizza build(){
            return new Pizza(this);
        }
    }
}
