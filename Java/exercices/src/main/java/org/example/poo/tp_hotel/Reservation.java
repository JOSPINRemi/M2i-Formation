package org.example.poo.tp_hotel;

public class Reservation {
    private int numero;
    private String statut;
    private Client client;
    private Chambre chambre;

    public Reservation(int numero, String statut, Client client, Chambre chambre) {
        this.numero = numero;
        this.statut = statut;
        this.client = client;
        this.chambre = chambre;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Chambre getChambre() {
        return chambre;
    }

    public void setChambre(Chambre chambre) {
        this.chambre = chambre;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "numero=" + numero +
                ", statut='" + statut + '\'' +
                ", client=" + client +
                ", chambre=" + chambre +
                '}';
    }
}
