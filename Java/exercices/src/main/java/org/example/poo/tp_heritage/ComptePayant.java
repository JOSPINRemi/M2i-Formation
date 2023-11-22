package org.example.poo.tp_heritage;

public class ComptePayant extends Compte {

    public ComptePayant(double solde) {
        super(solde);
    }

    public void versement(double montant) {
        solde += montant;
        solde -= (montant * 5 / 100);
    }

    public void retrait(double montant) {
        solde -= montant;
        solde -= (montant * 5 / 100);
    }
}
