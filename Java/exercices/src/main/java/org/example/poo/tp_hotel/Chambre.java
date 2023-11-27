package org.example.poo.tp_hotel;

public class Chambre {
    private static int counter;
    private int numero;
    private String statut;
    private float tarif;
    private int capacite;

    {
        counter++;
    }

    public Chambre(String statut, float tarif, int capacite) {
        this.numero = counter;
        this.statut = statut;
        this.tarif = tarif;
        this.capacite = capacite;
    }

    public int getNumero() {
        return numero;
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
                "numéro=" + numero +
                ", statut='" + statut + '\'' +
                ", tarif=" + tarif +
                ", capacite=" + capacite +
                '}';
    }
}
