package org.example.exercice_strategy;

public class EconomicStrategy implements NavigationStrategy {
    @Override
    public void navigate(String destination) {
        System.out.println("EconomicStrategy to " + destination);
    }
}
