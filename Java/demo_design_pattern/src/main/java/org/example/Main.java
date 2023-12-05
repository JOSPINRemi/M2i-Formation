package org.example;

import org.example.demo_builder.Voiture;

public class Main {
    public static void main(String[] args) {
        Voiture voiture = new Voiture.Builder()
                .marque("tesla")
                .modele("3")
                .build();

        voiture = new Voiture.Builder()
                .marque("m1")
                .build();
    }
}
