package org.example.exercice_interface_fonctionnelle_stream;

@FunctionalInterface
public interface CritereFiltrage {

    boolean filtrer(Produit produit);
}
