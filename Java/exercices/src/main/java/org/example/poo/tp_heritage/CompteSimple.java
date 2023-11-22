package org.example.poo.tp_heritage;

public class CompteSimple extends Compte {
    private float decouvert;

    public CompteSimple(double solde, float decouvert) {
        super(solde);
        this.decouvert = -decouvert;
    }

    public void retrait(double montant) {
        if (solde - montant > decouvert) {
            solde -= montant;
        } else {
            System.out.println("Opération non autorisée, dépassement du découvert");
        }
    }
}
