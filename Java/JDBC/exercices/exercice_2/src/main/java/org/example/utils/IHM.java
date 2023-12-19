package org.example.utils;

import org.example.service.Service;

import java.util.Scanner;

public class IHM {
    private Service service = new Service();
    private Scanner scanner = new Scanner(System.in);

    public void start() {
        boolean running = true;
        while (running) {
            System.out.println("1. Créer un client");
            System.out.println("5. Quitter");
            System.out.println("Choix : ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> {
                    System.out.print("Nom : ");
                    String nom = scanner.nextLine();
                    System.out.print("Prénom : ");
                    String prenom = scanner.nextLine();
                    System.out.print("Téléphone : ");
                    String telephone = scanner.nextLine();
                    if (service.createClient(nom, prenom, telephone)) {
                        System.out.println("Client créé avec succès");
                    }
                    else {
                        System.out.println("Problème lors de la création du client");
                    }
                }
                default -> {
                    System.out.println("Choix invalide");
                }
            }
        }
    }
}
