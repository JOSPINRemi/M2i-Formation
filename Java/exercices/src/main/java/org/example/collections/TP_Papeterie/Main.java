package org.example.collections.TP_Papeterie;

public class Main {
    public static void main(String[] args) {
        BDD bdd = new BDD();
        Article styloBleu = new Stylo("SBLE", "Stylo Bleu");
        Article styloNoir = new Stylo("SN", "Stylo Noir", 1.5, "noir");
        Article ramette = new Ramette("R", "Ramette", 25, 0.5);
        bdd.ajouterArticle(styloBleu);
        bdd.ajouterArticle(styloNoir);
        bdd.ajouterArticle(ramette);

        Lot lot = new Lot("SN", 2, 15);
        bdd.ajouterArticle(lot);

        Facture facture = new Facture("Moi");
        facture.ajouterLigne("SBLE", 1);
        facture.ajouterLigne(lot.getReference(), 1);
        facture.ajouterLigne("R", 25);
        for (Ligne ligne : facture.getQuantiteLigneAchat()) {
            System.out.println(ligne.afficheLigne());
        }
        System.out.println(facture.getPrixTotal());
    }
}
