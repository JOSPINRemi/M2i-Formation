package org.example;

import org.example.service.BilletterieService;
import org.example.utils.ConsoleIHM;

public class Main {
    public static void main(String[] args) {
        new ConsoleIHM(new BilletterieService()).start();
    }
}