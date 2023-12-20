package org.example.utils;

import org.example.models.Client;
import org.example.models.CompteBancaire;
import org.example.models.OperationStatut;
import org.example.service.Service;

import java.util.Scanner;

public class IHM {
    private final Service service;
    private final Scanner scanner;

    public IHM() {
        service = new Service();
        scanner = new Scanner(System.in);
    }

    public void start() {
        boolean running = true;
        while (running) {
            System.out.println("1 - Créer un client et un compte");
            System.out.println("2 - Dépôt");
            System.out.println("3 - Retrait");
            System.out.println("4 - Affichage compte");
            System.out.println("0 - Quitter");
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
                    Client client = service.createClient(nom, prenom, telephone);
                    if (client != null) {
                        System.out.println("Client créé avec succès");
                        System.out.print("Quel solde voulez-vous sur votre compte : ");
                        double solde = scanner.nextDouble();
                        scanner.nextLine();
                        CompteBancaire compteBancaire = service.createCompteBancaire(solde, client);
                        if (compteBancaire != null) {
                            System.out.println("Compte créé avec succès");
                        } else {
                            System.out.println("Problème lors de la création du compte");
                        }
                    } else {
                        System.out.println("Problème lors de la création du client");
                    }
                }
                case 2 -> {
                    CompteBancaire compteBancaire = selectionCompteBancaire();
                    if(compteBancaire != null){
                        System.out.print("Quel est le montant du dépôt : ");
                        double montant = scanner.nextDouble();
                        scanner.nextLine();

                        if(service.createOperation(montant, OperationStatut.DEPOT) != null){
                            compteBancaire.depot(montant);
                            service.updateCompteBancaire(compteBancaire);
                            System.out.println("Dépôt réalisé avec succès");
                        }
                        else {
                            System.out.println("Problème lors du dépôt");
                        }
                    }
                }
                case 3 -> {
                    CompteBancaire compteBancaire = selectionCompteBancaire();
                    if(compteBancaire != null){
                        System.out.print("Quel est le montant du retrait : ");
                        double montant = scanner.nextDouble();
                        scanner.nextLine();

                        if(service.createOperation(montant, OperationStatut.RETRAIT) != null){
                            compteBancaire.retrait(montant);
                            service.updateCompteBancaire(compteBancaire);
                            System.out.println("Retrait réalisé avec succès");
                        }
                        else {
                            System.out.println("Problème lors du retrait");
                        }
                    }
                }
                case 4 -> showCustomerAccounts();
                case 0 -> running = false;
                default -> System.out.println("Choix invalide");
            }
        }
        System.out.println("Bye");
    }

    private CompteBancaire selectionCompteBancaire() {
        showCustomerAccounts();
        System.out.print("Sur quel compte souhaitez vous faire l'opération : ");
        int numCompte = scanner.nextInt();
        return service.getCompteBancaire(numCompte);
    }

    private void showCustomerAccounts() {
        service.getAllClients().forEach(System.out::println);
        System.out.print("Quel est votre numéro de client : ");
        int numClient = scanner.nextInt();
        scanner.nextLine();

        for (CompteBancaire compteBancaire : service.getAllCompteBancaire()){
            if (compteBancaire.getClient().getId() == service.getClient(numClient).getId()){
                System.out.println(compteBancaire);
            }
        }
    }
}
