package org.example;

import org.example.service.BilletterieService;
import org.example.utils.ConsoleIHM;

public class Main {
    public static void main(String[] args) {
        // TODO: 22/12/2023 Ajouter des transactions sur chacune des actions
        new ConsoleIHM(new BilletterieService()).start();
    }
}