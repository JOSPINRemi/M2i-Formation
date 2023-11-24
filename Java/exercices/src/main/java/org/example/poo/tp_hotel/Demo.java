package org.example.poo.tp_hotel;

import java.util.Objects;
import java.util.Scanner;

public class Demo {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String hotelName;
        int menuChoice;
        String lastName;
        String firstName;
        String phoneNumber;

        System.out.println("Saisir le nom de l'hôtel : ");
        hotelName = scanner.next();
        Hotel hotel = new Hotel(hotelName);

        do {
            System.out.println("1 - Ajouter un client");
            System.out.println("2 - Afficher la liste des clients");
            System.out.println("3 - Affihcer les réservations d'un client");
            System.out.println("4 - Ajouter une réservation");
            System.out.println("5 - Annuler une réservation");
            System.out.println("6 - Afficher la liste des réservations");

            menuChoice = scanner.nextInt();
            scanner.nextLine();

            switch (menuChoice) {
                case 1:
                    System.out.println("Saisir votre nom :");
                    lastName = scanner.nextLine();
                    System.out.println("Saisir votre prénom :");
                    firstName = scanner.nextLine();
                    System.out.println("Saisir votre numéro de téléphone :");
                    phoneNumber = scanner.nextLine();
                    hotel.addClient(new Client(lastName, firstName, phoneNumber));
                    break;
                case 2:
                    if (hotel.getClients().length == 0) {
                        System.out.println("La liste de client est vide");
                    } else {
                        for (Client client : hotel.getClients()) {
                            System.out.println(client);
                        }
                    }
                    System.out.println();
                    break;
                case 3:
                    System.out.println("Saisissez votre numéro de téléphone :");
                    phoneNumber = scanner.nextLine();
                    boolean clientExists = false;
                    boolean reservationsExists = false;
                    for (Client client : hotel.getClients()) {
                        if (client.getTelephone().equals(phoneNumber)) {
                            clientExists = true;
                            for (Reservation reservation : hotel.getReservations()) {
                                if (reservation.getClient().equals(client)) {
                                    reservationsExists = true;
                                    System.out.println(reservation);
                                }
                            }
                            break;
                        }
                    }
                    if (!clientExists) {
                        System.out.println("Le client avec le numéro de téléphone " + phoneNumber + " n'est pas enregistré");
                    }
                    if (!reservationsExists) {
                        System.out.println("Le client avec le numéro de téléphone " + phoneNumber + " n'a pas de réservations");
                    }
                    break;
//                TODO: Créer le cas pour Ajouter une réservation
                /*case 4:
                    break;*/
//                TODO: Créer le cas pour Annuler une réservation
                /*case 5:
                    break;*/
//                TODO: Créer le cas pour Afficher la liste des réservations
                /*case 6:
                    break;*/
                case 0:
                    System.out.println("Merci d'avoir utilisé mon service de gestion d'hôtel");
                    break;
                default:
                    System.out.println("Saisie invalide\n");
                    break;
            }
        } while (menuChoice != 0);
    }
}
