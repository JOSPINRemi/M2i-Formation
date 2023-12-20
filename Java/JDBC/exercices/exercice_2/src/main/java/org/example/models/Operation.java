package org.example.models;

public class Operation {
    private int numero;
    private double montant;
    private OperationStatut statut;

    public Operation() {
    }

    public Operation(int numero, double montant, OperationStatut statut) {
        this.numero = numero;
        this.montant = montant;
        this.statut = statut;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public OperationStatut getStatut() {
        return statut;
    }

    public void setStatut(OperationStatut statut) {
        this.statut = statut;
    }

    @Override
    public String toString() {
        return "Operation{" +
                "numero=" + numero +
                ", montant=" + montant +
                ", statut=" + statut +
                '}';
    }
}
