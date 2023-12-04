package org.example.exercice_interface_fonctionnelle_stream;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Produit> produits = new ArrayList<>();
        produits.add(new Produit("tomate", 1.5, "fruit"));
        produits.add(new Produit("caviar", 15, "poisson"));

        List<Produit> produitsFiltres = Utilitaires.filtrerProduits(produits, (produit -> produit.getPrix() > 10));
        System.out.println(produitsFiltres);
    }
}
