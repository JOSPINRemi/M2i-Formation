package org.example.poo.enums;

import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MessageType[] values = MessageType.values();
        String typeOfMessage;
        boolean isValidType = false;
        do {
            System.out.println("Entrer le type de message :");
            typeOfMessage = scanner.next();
            for (MessageType p : values) {
                if (p.toString().equals(typeOfMessage)) {
                    isValidType = true;
                    break;
                }
            }
            if (!isValidType) {
                System.out.println("Saisie invalide\n");
            }
        } while (!isValidType);
        MessageType valueOfMessage = MessageType.valueOf(typeOfMessage);
        System.out.println("La priorité du message de type " + typeOfMessage + " est " + valueOfMessage.getPriority());
    }
}
