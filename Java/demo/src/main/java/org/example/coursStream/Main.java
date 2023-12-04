package org.example.coursStream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Calculatrice calculatrice = new Calculatrice();
        double totalAddition = calculatrice.calcule(10, 30, (a,b) -> a + b);
        double totalSoustraction = calculatrice.calcule(10, 30, Calculatrice::soustraction);

        System.out.println("totalAddition : " + totalAddition);
        System.out.println("totalSoustraction : " + totalSoustraction);

        List<Produit> produits = Arrays.asList(
                new Produit("p1", "c1", 20),
                new Produit("p2", "c1", 50),
                new Produit("p3", "c2", 200),
                new Produit("p4", "c2", 3000)
        );
//        Filtrer avec un stream
        System.out.println(produits.stream().filter(produit -> produit.getPrix() > 50).collect(Collectors.toList()));

//        Map pour convertir un stream en un autre
        System.out.println(produits.stream().map(produit -> produit.getPrix()).collect(Collectors.toList()));
        produits.forEach(System.out::println);
    }
}
