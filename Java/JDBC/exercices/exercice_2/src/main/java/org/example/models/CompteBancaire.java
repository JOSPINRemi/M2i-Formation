package org.example.models;

import java.util.ArrayList;
import java.util.List;

public class CompteBancaire {
    private int id;
    private double solde;
    private Client client;
    private List<Operation> operations;

    public CompteBancaire() {
    }

    public CompteBancaire(int id, double solde, Client client) {
        this.id = id;
        this.solde = solde;
        this.client = client;
        this.operations = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getSolde() {
        return solde;
    }

    public void setSolde(double solde) {
        this.solde = solde;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @Override
    public String toString() {
        return "CompteBancaire{" +
                "solde=" + solde +
                ", client=" + client +
                ", operations=" + operations +
                '}';
    }

    public void depot(double montant){
        solde += montant;
    }
    public void retrait(double montant){
        solde -= montant;
    }
}
