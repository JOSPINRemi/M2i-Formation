package org.example.demo_strategy;

import java.util.Random;

public class CardPaymentStrategy implements PaymentStrategy {
    private Random random = new Random();
    @Override
    public boolean pay(double amount) {
        System.out.println("Card payment Strategy");
        return random.nextBoolean();
    }
}
