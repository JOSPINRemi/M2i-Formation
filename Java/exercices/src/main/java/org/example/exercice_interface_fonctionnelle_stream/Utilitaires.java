package org.example.exercice_interface_fonctionnelle_stream;

import java.util.ArrayList;
import java.util.List;

public class Utilitaires {
    public static List<Produit> filtrerProduits(List<Produit> produits, CritereFiltrage critereFiltrage) {
        List<Produit> produitsFiltres = new ArrayList<>();
        for (Produit produit : produits) {
            if (critereFiltrage.filtrer(produit)) {
                produitsFiltres.add(produit);
            }
        }
        return produitsFiltres;
    }
}
