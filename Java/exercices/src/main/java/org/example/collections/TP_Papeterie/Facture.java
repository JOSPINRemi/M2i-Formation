package org.example.collections.TP_Papeterie;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Facture {
    private int nbLigne;
    private int nbLigneMax = 10;
    private long numeroFacture;
    private long counter = 0;
    private String client;
    private LocalDate date;
    private List<Ligne> quantiteLigneAchat;

    public Facture(String client, LocalDate date) {
        this.nbLigne = 0;
        this.numeroFacture = ++counter;
        this.client = client;
        this.date = date;
        this.quantiteLigneAchat = new ArrayList<>();
    }

    public Facture(String client) {
        this(client, LocalDate.now());
    }

    public List<Ligne> getQuantiteLigneAchat() {
        return quantiteLigneAchat;
    }

    public boolean ajouterLigne(String reference, int quantite) {
        if (quantiteLigneAchat.size() < nbLigneMax) {
            return quantiteLigneAchat.add(new Ligne(BDD.articles.get(reference), quantite));
        }
        return false;
    }

    public double getPrixTotal() {
        double prixTotal = 0;
        for (Ligne ligne : quantiteLigneAchat) {
            if (ligne.getArticle() instanceof ArticleUnitaire) {
                prixTotal += ((ArticleUnitaire) BDD.articles.get(ligne.getArticle().getReference())).getPrixUnitaire() * ligne.getQuantiteAchetee();
            } else if (ligne.getArticle() instanceof Lot) {
                if (((Lot) ligne.getArticle()).getArticle() instanceof ArticleUnitaire) {
                    double remise = ((Lot) ligne.getArticle()).getQuantite() * ((ArticleUnitaire) ((Lot) ligne.getArticle()).getArticle()).prixUnitaire * ((Lot) ligne.getArticle()).getPourcentageRemise();
                    prixTotal += (((Lot) ligne.getArticle()).getQuantite() * ((ArticleUnitaire) ((Lot) ligne.getArticle()).getArticle()).getPrixUnitaire() - remise) * ligne.getQuantiteAchetee();
                }
            }

        }
        return prixTotal;
    }
}
