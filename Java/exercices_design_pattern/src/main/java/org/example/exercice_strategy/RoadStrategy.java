package org.example.exercice_strategy;

public class RoadStrategy implements NavigationStrategy {
    @Override
    public void navigate(String destination) {
        System.out.println("RoadStrategy to " + destination);
    }
}
