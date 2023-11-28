package org.example.readFromConsole;

import java.util.Scanner;

public class ReadFromConsole {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Entrer un entier :");
        int num = scanner.nextInt();
        System.out.println("Nombre saisi : " + num);

        System.out.println("Entrer une chaîne de caractère :");
        scanner.nextLine();
        String str = scanner.nextLine();
        System.out.println("Chaîne de caratère saisie : " + str);
    }
    public static void getReadWrite() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Donne moi un  : ");
        String nom = scanner.next();
        System.out.println("Le nom saisi est " + nom);
        System.out.println("Donne moi un nombre : ");
        Integer nombre = scanner.nextInt();
        System.out.println("Le nombre saisi est " + nombre);
    }
}
