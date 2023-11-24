package org.example.poo.tp_hotel;

public class Chambre {
    private int numéro;
    private String statut;
    private float tarif;
    private int capacite;

    public Chambre(int numéro, String statut, float tarif, int capacite) {
        this.numéro = numéro;
        this.statut = statut;
        this.tarif = tarif;
        this.capacite = capacite;
    }

    public int getNuméro() {
        return numéro;
    }

    public void setNuméro(int numéro) {
        this.numéro = numéro;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public float getTarif() {
        return tarif;
    }

    public void setTarif(float tarif) {
        this.tarif = tarif;
    }

    public int getCapacite() {
        return capacite;
    }

    public void setCapacite(int capacite) {
        this.capacite = capacite;
    }

    @Override
    public String toString() {
        return "Chambre{" +
                "numéro=" + numéro +
                ", statut='" + statut + '\'' +
                ", tarif=" + tarif +
                ", capacite=" + capacite +
                '}';
    }
}
