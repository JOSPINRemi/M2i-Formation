package org.example.exercice2;

public class Price {
    public static void getPrice() {
        float prixHT = 15.51F;
        int nbArticle = 3;
        int TVA = 15;
        System.out.println("Pour un prix HT de " + prixHT);
        System.out.println("Pour un nombre d'article de " + nbArticle);
        System.out.println("Pour une TVA de " + TVA);
        System.out.println("Le prix TTC est de " + ((prixHT * (1 + (TVA / 100))) * nbArticle));
    }
}
