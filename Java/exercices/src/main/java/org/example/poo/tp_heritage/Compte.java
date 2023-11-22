package org.example.poo.tp_heritage;

public class Compte {

    static int counter;
    private int code;
    protected double solde;

    {
        counter++;
    }

    public Compte(double solde) {
        this.code = counter;
        this.solde = solde;
    }

    public void versement(double montant) {
        solde += montant;
    }

    public void retrait(double montant) {
        solde -= montant;
    }

    @Override
    public String toString() {
        return "Compte{" +
                "code=" + code +
                ", solde=" + solde +
                '}';
    }
}
