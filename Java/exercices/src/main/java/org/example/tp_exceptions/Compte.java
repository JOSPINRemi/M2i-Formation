package org.example.tp_exceptions;

public class Compte {
    private double solde;

    public Compte() {
        this.solde = 100;
    }

    public double getSolde() {
        return solde;
    }

    public void retirer(double montant) throws SoldeInsuffisantException {
        if (montant > solde) {
            throw new SoldeInsuffisantException("Solde insuffisant");
        }
        solde -= montant;
    }
}
