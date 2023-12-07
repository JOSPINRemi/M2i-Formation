package org.example.exercice_strategy;

public class OffroadStrategy implements NavigationStrategy {
    @Override
    public void navigate(String destination) {
        System.out.println("OffroadStrategy to " + destination);
    }
}
