package org.example.utils;

import jdk.jshell.spi.ExecutionControl;
import org.example.entity.Customer;
import org.example.entity.Event;
import org.example.entity.EventLocation;
import org.example.service.IBilletterieService;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class ConsoleIHM {
    private static Scanner scanner;
    private static IBilletterieService billetterieService;
    private String choice;

    public ConsoleIHM(IBilletterieService billetterieService) {
        scanner = new Scanner(System.in);
        this.billetterieService = billetterieService;
    }

    public void start() {
        do {
            menu();
            choice = scanner.nextLine();
            switch (choice) {
                case "1" -> {
                    subMenu("Lieux");
                    choice = scanner.nextLine();
                    switch(choice){
                        case "1" -> {
                            createEventLocation();
                        }
                        case "2" -> {
                            updateEventLocation();
                        }
                        case "3" -> {
                            deleteEventLocation();
                        }
                    }
                }
                /*case "2" -> {
                    subMenu("Evénement");
                    choice = scanner.nextLine();
                    switch(choice){
                        case "1" -> {}
                        case "2" -> {}
                        case "3" -> {}
                    }
                }*/
                /*case "3" -> {
                    subMenu("Client");
                    choice = scanner.nextLine();
                    switch(choice){
                        case "1" -> {}
                        case "2" -> {}
                        case "3" -> {}
                    }
                }*/
//                case "4" -> {}
//                case "5" -> {}
//                case "6" -> {}
//                case "7" -> {}
            }
        } while (!choice.equals("0"));
    }

    private void menu() {
        System.out.println("########## Menu Principal ##########");
        System.out.println("1- Ajouter, modifier et supprimer des lieux");
        System.out.println("2- Ajouter, modifier et supprimer des événements");
        System.out.println("3- Ajouter, modifier et supprimer des clients");
        System.out.println("4- Acheter des billets pour un événement");
        System.out.println("5- Annuler un achat de billet");
        System.out.println("6- Afficher la liste des événements disponibles");
        System.out.println("7- Afficher la liste des billets achetés par un client");
        System.out.println("0- Quitter");
        System.out.println(" Votre choix : ");
    }

    private void subMenu(String type) {
        System.out.println("########## Menu Secondaire ##########");
        System.out.println("########## " + type + " ##########");
        System.out.println("1- Ajouter");
        System.out.println("2- Modifier");
        System.out.println("3- Supprimer");
    }

    private void createEventLocation() {
        System.out.println("Merci de saisir le nom : ");
        String name = scanner.nextLine();
        System.out.println("Merci de saisir l'adresse : ");
        String address = scanner.nextLine();
        System.out.println("Merci de saisir la capacité : ");
        int capacity = scanner.nextInt();
        scanner.nextLine();
        EventLocation eventLocation = billetterieService.createAndSaveEventLocation(name, address, capacity);
        System.out.println("Le lieu a bien été créé avec l'id " + eventLocation.getId());
    }

    private void updateEventLocation(){}
    private void deleteEventLocation(){}

    private void createEvent() {
        System.out.println("##### Choix 1 #####");
        System.out.println("Merci de saisir le nom : ");
        String name = scanner.nextLine();
        System.out.println("Merci de saisir la date (yyyy-MM-dd) : ");
        String date = scanner.nextLine();
        System.out.println("Merci de saisir l'heure (HH:mm:ss) : ");
        String time = scanner.nextLine();
        LocalDateTime dateTime = ;
        uuuu-MM-dd'T'HH:mm:ss;
        2007-12-03T10:15:30;
        billetterieService.getAllEventLocation();
        int eventLocationId = scanner.nextInt();
        scanner.nextLine();
        EventLocation eventLocation;
        try {
            eventLocation = billetterieService.getEventLocationById(eventLocationId);
            if (eventLocation != null){

            }
            else {
                System.out.println("L'id saisi est invalide");
            }
        }

        String name = scanner.nextLine();
        Event event = billetterieService.createAndSaveEvent(name, dateTime, EventLocation, price);
    }

    private void createCustomer() {
        System.out.println("##### Choix 2 #####");
        System.out.println("Merci de saisir le nom : ");
        String lastName = scanner.nextLine();
        System.out.println("Merci de saisir le prénom : ");
        String firstName = scanner.nextLine();
        System.out.println("Merci de saisir l'email : ");
        String email = scanner.nextLine();
        Customer customer = billetterieService.createAndSaveCustomer(firstName, lastName, email);
        System.out.println("Client créé avec l'id " + customer.getId());
    }

    private void buyTicket() {
    }
}
