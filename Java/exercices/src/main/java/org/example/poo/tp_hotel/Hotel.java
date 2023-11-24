package org.example.poo.tp_hotel;

import java.util.Arrays;
import java.util.Random;

public class Hotel {
    private String name;
    private Chambre[] chambres;
    private Reservation[] reservations;
    private Client[] clients;

    public Hotel(String name) {
        this.name = name;
        this.chambres = new Chambre[10];
        this.reservations = new Reservation[0];
        this.clients = new Client[0];
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Chambre[] getChambres() {
        return chambres;
    }

    public void setChambres(Chambre[] chambres) {
        this.chambres = chambres;
    }

    public Reservation[] getReservations() {
        return reservations;
    }

    public void setReservations(Reservation[] reservations) {
        this.reservations = reservations;
    }

    public Client[] getClients() {
        return clients;
    }

    public void setClients(Client[] clients) {
        this.clients = clients;
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "name='" + name + '\'' +
                ", chambres=" + Arrays.toString(chambres) +
                ", reservations=" + Arrays.toString(reservations) +
                ", clients=" + Arrays.toString(clients) +
                '}';
    }

    public void addClient(Client client) {
        Client[] tmp = new Client[clients.length + 1];
        for (int i = 0; i < clients.length; i++) {
            tmp[i] = clients[i];
        }
        tmp[tmp.length - 1] = client;
        clients = tmp;
    }
}
