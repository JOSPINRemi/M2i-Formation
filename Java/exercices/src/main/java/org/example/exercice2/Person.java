package org.example.exercice2;

import java.util.Scanner;

public class Person {
    public static void getFirstname() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Quel est votre prénom ?");
        String firstname = scanner.next();
        System.out.println("Bonjour, " + firstname + " !");
    }
}
