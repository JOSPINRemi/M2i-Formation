package org.example.models;

import java.util.ArrayList;
import java.util.List;

public class Client {
    private String nom;
    private String prenom;
    private int id;
    private List<CompteBancaire> comptes;
    private String telephone;

    public Client() {
    }

    public Client(String nom, String prenom, int id, String telephone) {
        this.nom = nom;
        this.prenom = prenom;
        this.id = id;
        this.comptes = new ArrayList<>();
        this.telephone = telephone;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<CompteBancaire> getComptes() {
        return comptes;
    }

    public void addCompte(CompteBancaire compte) {
        comptes.add(compte);
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    @Override
    public String toString() {
        return "Client{" +
                "nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", id=" + id +
                ", comptes=" + comptes +
                ", telephone='" + telephone + '\'' +
                '}';
    }
}
