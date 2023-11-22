package org.example.poo.tp_heritage;

public class CompteEpargne extends Compte {
    private int tauxInteret;

    public CompteEpargne(double solde, int tauxInteret) {
        super(solde);
        this.tauxInteret = tauxInteret;
    }

    public void calculInteret() {
        solde += (solde * tauxInteret / 100);
    }
}
