package org.example.exercice_strategy;

public class NavigationSystem {
    private NavigationStrategy navigationStrategy;

    public NavigationSystem(NavigationStrategy navigationStrategy) {
        this.navigationStrategy = navigationStrategy;
    }

    public NavigationSystem() {
        this(new EconomicStrategy());
    }

    public NavigationStrategy getNavigationStrategy() {
        return navigationStrategy;
    }

    public void setNavigationStrategy(NavigationStrategy navigationStrategy) {
        this.navigationStrategy = navigationStrategy;
    }
}
