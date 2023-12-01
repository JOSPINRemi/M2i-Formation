package org.example;

import org.example.classes.Client;
import org.example.classes.Event;
import org.example.classes.Location;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class IHMConsole {
    private static Scanner scanner;
    private static List<Event> events;
    private static List<Location> locations;
    private static List<Client> clients;

    public static void start(){
        scanner = new Scanner(System.in);

        events = new ArrayList<>();
        locations = new ArrayList<>();
        clients = new ArrayList<>();

        menu();
    }

    private static void menu(){
        String[] proposals = {
                "1 - Ajouter, modifier et supprimer des lieux",
                "2 - Ajouter, modifier et supprimer des événements",
                "3 - Ajouter, modifier et supprimer des clients",
                "4 - Acheter des billets pour un événement",
                "5 - Annuler un achat de billet",
                "6 - Afficher la liste des événements disponibles",
                "7 - Afficher la liste des billets achetés par un client",
                "0 - Quitter"
        };
        int choice;

        System.out.println("Que souhaitez vous faire :");
        for (String proposal : proposals) {
            System.out.println(proposal);
        }

        choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice){
            case 1, 2, 3 -> subMenu(choice);
            case 4 -> {
                boolean eventExists = false, clientExists = false;
                if (events.isEmpty()){
                    System.out.println("Aucun événement pour le moment");
                    menu();
                }
                for (Event event : events) {
                    System.out.println(event);
                }
                System.out.println("Pour quel événement souhaitez-vous acheter un billet (saisir le nom)");
                String eventName = scanner.nextLine().trim().toLowerCase();
                for (Event event : events) {
                    if (event.getName().trim().toLowerCase().equals(eventName)){
                        eventExists = true;
                        if (clients.isEmpty()){
                            break;
                        }
                        System.out.println("Quel est votre nom");
                        String lastName = scanner.nextLine().trim().toLowerCase();

                        System.out.println("Quel est votre prénom");
                        String firstName = scanner.nextLine().trim().toLowerCase();

                        System.out.println("Avez-vous enregistré votre adresse email ? (o/n)");
                        String rep = scanner.nextLine();
                        if (rep.equals("o")){
                            System.out.println("Quel est votre adresse email");
                            String email = scanner.nextLine().trim().toLowerCase();
                            for (Client client : clients) {
                                if (client.getLastName().trim().toLowerCase().equals(lastName) &&
                                        client.getFirstName().trim().toLowerCase().equals(firstName) &&
                                        client.getEmail().trim().toLowerCase().equals(email)){
                                    if (client.buyTicket(event)){
                                        event.sellTicket();
                                        System.out.println("Billet acheté");
                                    }
                                    clientExists = true;
                                }
                            }
                        }
                        else {
                            for (Client client : clients) {
                                if (client.getLastName().trim().toLowerCase().equals(lastName) &&
                                client.getFirstName().trim().toLowerCase().equals(firstName)){
                                    if (client.buyTicket(event)){
                                        event.sellTicket();
                                        System.out.println("Billet acheté");
                                    }
                                    clientExists = true;
                                }
                            }
                        }
                    }
                }
                if (!eventExists){
                    System.out.println("L'événement demandé n'existe pas");
                }
                if (!clientExists){
                    System.out.println("Inscrivez-vous avant d'acheter un billet");
                }
                menu();
            }
//            TODO Annuler un achat de billet
            case 5 -> {
                menu();
            }
            case 6 -> {
                boolean eventAvailable = false;
                if (events.isEmpty()){
                    System.out.println("Aucun événement pour le moment");
                    menu();
                }
                for (Event event : events) {
                    if (event.isTicketAvailable()){
                        System.out.println(event);
                        eventAvailable = true;
                    }
                }
                if (!eventAvailable){
                    System.out.println("Aucun ticket disponible pour le moment pour un événement en cours");
                }
                menu();
            }
//            TODO Afficher la liste des billets achetés par un client
            case 7 -> {
                menu();
            }
            case 0 -> {
            }
            default -> {
                System.out.println("Choix invalide");
                menu();
            }
        }
    }

    private static void subMenu(int menuChoice){
        String[] proposals = {
                "1 - Ajouter",
                "2 - Modifier",
                "3 - Supprimer"
        };
        int choice;

        System.out.println("Que souhaitez vous faire plus particulièrement");
        for (String proposal : proposals) {
            switch (menuChoice){
                case 1 -> System.out.println(proposal + " un lieux");
                case 2 -> System.out.println(proposal + " un événement");
                case 3 -> System.out.println(proposal + " un client");
            }
        }

        choice = scanner.nextInt();
        scanner.nextLine();

        switch (menuChoice){
            case 1 -> {
                switch (choice){
                    case 1 -> {
                        System.out.println("Quel est le nom du lieu ?");
                        String locationName = scanner.nextLine().trim();
                        System.out.println("Quelle est l'adresse du lieu ?");
                        String locationAddress = scanner.nextLine().trim();
                        System.out.println("Quel est la capacité d'accueil du lieux ?");
                        int locationCapacity = scanner.nextInt();
                        scanner.nextLine();
                        locations.add(new Location(locationName, locationAddress, locationCapacity));
                    }
//                    TODO modification d'un lieu
//                    TODO suppression d'un lieu
                }
                menu();
            }
            case 2 -> {
                switch (choice) {
                    case 1 -> {
                        boolean locationExists = false;
                        if (!locations.isEmpty()){
                            System.out.println("Quel est le nom de l'événement");
                            String eventName = scanner.nextLine();

                            for (Location location : locations) {
                                System.out.println(location);
                            }
                            System.out.println("Quel est le lieu de l'événement");
                            System.out.println("Saisir le nom du lieu :");
                            String locationName = scanner.nextLine().trim().toLowerCase();
                            System.out.println("Saisir l'adresse du lieu :");
                            String locationAddress = scanner.nextLine().trim().toLowerCase();
                            for (Location location : locations) {
                                if (location.getName().toLowerCase().equals(locationName) &&
                                location.getAddress().toLowerCase().equals(locationAddress)){
                                    System.out.println("Quel est le prix de l'événement");
                                    double eventPrice = scanner.nextDouble();
                                    scanner.nextLine();
                                    System.out.println("L'événment a-t-il lieu aujourd'hui (o/n)");
                                    String rep = scanner.nextLine().trim().toLowerCase();
                                    if (rep.equals("o")){
                                        if (events.add(new Event(eventName, location, eventPrice))){
                                            System.out.println("L'événement à été ajouté");
                                        }
                                    }
                                    else if (rep.equals("n")){
                                        System.out.println("Saisir la date de l'événement au format aaaa-mm-jj");
                                        LocalDate eventDate = LocalDate.parse(scanner.nextLine().trim());
                                        System.out.println("Saisir l'heure de l'événement au format hh:mm");
                                        LocalTime eventTime = LocalTime.parse(scanner.nextLine().trim());
                                        if (events.add(new Event(eventName, eventDate, eventTime, location, eventPrice))){
                                            System.out.println("L'événement à été ajouté");
                                        }
                                    }
                                    locationExists = true;
                                    break;
                                }
                            }

                        }
                        if (!locationExists){
                            System.out.println("Veuillez ajouter le lieu avant d'ajouter l'événement");
                            menu();
                        }
                    }
//                    TODO modification d'un événement
//                    TODO suppression d'un événement
                }
                menu();
            }
            case 3 -> {
                switch (choice) {
                    case 1 -> {
                        System.out.println("Quel est le nom du client :");
                        String clientLastName = scanner.nextLine();
                        System.out.println("Quel est le prénom du client :");
                        String clientFirstName = scanner.nextLine();
                        System.out.println("Souhaitez-vous ajouter votre adresse mail (o/n)");
                        String rep = scanner.nextLine().trim().toLowerCase();
                        if (rep.equals("o")){
                            System.out.println("Quel est l'adresse email du client :");
                            String clientEmail = scanner.nextLine();
                            clients.add(new Client(clientLastName, clientFirstName, clientEmail));
                        } else{
                            clients.add(new Client(clientLastName, clientFirstName));
                        }
                    }
//                    TODO modification d'un client
//                    TODO suppression d'un client
                }
                menu();
            }
        }
    }
}
