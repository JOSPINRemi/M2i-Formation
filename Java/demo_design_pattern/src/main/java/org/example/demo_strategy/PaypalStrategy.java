package org.example.demo_strategy;

import java.util.Random;

public class PaypalStrategy implements PaymentStrategy {
    private Random random = new Random();
    @Override
    public boolean pay(double amount) {
        System.out.println("Paypal Strategy");
        return random.nextBoolean();
    }
}
