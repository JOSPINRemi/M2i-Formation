package org.example.HCI;

import org.example.Student;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class CLI {
    private static Scanner scanner = new Scanner(System.in);

    public static void start() throws SQLException {
        menu();
    }

    private static void menu() throws SQLException {
        String[] proposals = {
                "1 - Ajouter un étudiant",
                "2 - Afficher la totalité des etudiants",
                "3 - Afficher les etudiants d'une classes",
                "4 - Supprimer un etudiant",
                "q - Quitter"
        };
        String choice;
        for (String proposal : proposals) {
            System.out.println(proposal);
        }
        choice = scanner.nextLine();

        switch (choice) {
            case "1" -> {
                System.out.println("-- Ajout d'un étudiant --");
                System.out.println("Saisir un nom :");
                String lastName = scanner.nextLine();
                System.out.println("Saisir un prénom :");
                String firstName = scanner.nextLine();
                System.out.println("Saisir un numéro de classe :");
                int classNumber = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Saisir une date de diplôme (aaaa-mm-jj):");
                Date degreeDate = Date.valueOf(scanner.nextLine());
                System.out.println(Student.addStudent(lastName, firstName, classNumber, degreeDate) + " étudiants ajoutés");

                menu();
            }
            case "2" -> {
                System.out.println("-- Affichage de tous les étudiants --");
                ResultSet resultSet = Student.showStudents();
                while (resultSet.next()) {
                    System.out.println(
                            resultSet.getString("last_name") + " " +
                                    resultSet.getString("first_name") + " " +
                                    resultSet.getInt("class_number") + " " +
                                    resultSet.getDate("degree_date")
                    );
                }
                menu();
            }
           /* case "3" -> {
                System.out.println("-- Affichage des étudiants d'une classe --");
                Student.showStudentsFromClass(1);
                menu();
            }*/
            /*case "4" -> {
                System.out.println("-- Suppression d'un étudiant --");
                Student.deleteStudent(1);
                menu();
            }*/
            case "q" -> System.out.println("Merci d'avoir utilisé mon application de gestion d'étudiant");

            default -> {
                System.out.println("Saisie invalide");
                menu();
            }
        }
    }
}
