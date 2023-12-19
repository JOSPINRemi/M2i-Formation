package org.example.utils;

import org.example.models.Person;
import org.example.service.PersonService;

import java.util.Scanner;

public class ConsoleIHM {
    private final Scanner scanner;
    private final PersonService personService;

    public ConsoleIHM() {
        scanner = new Scanner(System.in);
        personService = new PersonService();
    }

    public void start() {
        String choice;
        do {
            menu();
            choice = scanner.nextLine();
            switch (choice) {
                case "1" -> {
                    System.out.println("Saisir le prénom :");
                    String firstName = scanner.nextLine();
                    System.out.println("Saisir le nom :");
                    String lastName = scanner.nextLine();
                    if (personService.createPerson(firstName, lastName)) {
                        System.out.println("Utilisateur créé");
                    } else {
                        System.out.println("Erreur lors de la création de l'utilisateur");
                    }
                }
                case "2" -> {
                    Person person;
                    System.out.println("Saisir l'id de la personne à modifier :");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    person = personService.getPerson(id);
                    if (person != null) {
                        System.out.println(person);
                        System.out.println("Saisir le prénom :");
                        String firstName = scanner.nextLine();
                        System.out.println("Saisir le nom :");
                        String lastName = scanner.nextLine();
                        person.setFirstName(firstName);
                        person.setLastName(lastName);
                        if (personService.updatePerson(person)) {
                            System.out.println("Utilisateur modifié avec succès");
                        }
                        else {
                            System.out.println("Problème lors de la mise à jour de l'utilisateur");
                        }
                    } else {
                        System.out.println("Pas de personne avec cet id");
                    }
                }
                case "3" -> {
                    System.out.println("Saisir l'id de l'utilisateur à supprimer :");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    if (personService.deletePerson(id)) {
                        System.out.println("Utilisateur supprimé avec succès");
                    } else {
                        System.out.println("Problème lors de la suppression de l'utilisateur");
                    }
                }
                case "4" -> personService.getAllPersons().forEach(System.out::println);
            }
        } while (!choice.equals("0"));
    }

    private void menu() {
        String[] proposals = {
                "1 - Créer utilisateur",
                "2 - Modifier utilisateur",
                "3 - Supprimer utilisateur",
                "4 - Afficher tous les utilisaturs",
                "0 - Quitter",
        };
        for (String proposal : proposals) {
            System.out.println(proposal);
        }
        System.out.println("Choix :");
    }
}
