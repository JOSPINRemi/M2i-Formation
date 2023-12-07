package org.example;

import org.example.exercice_strategy.EconomicStrategy;
import org.example.exercice_strategy.NavigationSystem;
import org.example.exercice_strategy.OffroadStrategy;
import org.example.exercice_strategy.RoadStrategy;
import org.example.exercice_visiteur.*;

import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
//        Exercice builder
        /*Pizza pizza = new Pizza.Builder()
                .taille("moyenne")
                .typeDePate("fine")
                .fromage("mozzarella")
                .garnitures(new ArrayList<>(Arrays.asList("jambon", "champignons")))
                .typeDeSauce("tomate")
                .build();
        System.out.println(pizza);*/

//        Exercice Abstract Factory
        /*Restaurant restaurant = new Restaurant(new ItalianCuisineFactory());
        restaurant.runPlate();
        restaurant.setCuisineFactory(new JapaneseCuisineFactory());
        restaurant.runPlate();*/

//        Exercice Observable
        /*Product product = new Product(10);
        StockManager stockManager = new StockManager();
        Supplier supplier = new Supplier();
        product.registerObserver(stockManager);
        product.registerObserver(supplier);

        product.setStockLevel(15);

        product.removeObserver(supplier);
        product.setStockLevel(16);*/

//        Exercice Strategy
        /*NavigationSystem navigationSystem = new NavigationSystem();
        String choice;
        String destination;

        System.out.println("Where do you want to go ?");
        destination = scanner.nextLine();
        do {
            System.out.println("1 -- RoadStrategy");
            System.out.println("2 -- OffroadStrategy");
            System.out.println("3 -- EconomicStrategy");
            System.out.println("0 -- Quit");
            choice = scanner.nextLine();
            switch (choice) {
                case "1" -> {
                    navigationSystem.setNavigationStrategy(new RoadStrategy());
                    navigationSystem.getNavigationStrategy().navigate(destination);
                }
                case "2" -> {
                    navigationSystem.setNavigationStrategy(new OffroadStrategy());
                    navigationSystem.getNavigationStrategy().navigate(destination);
                }
                case "3" -> {
                    navigationSystem.setNavigationStrategy(new EconomicStrategy());
                    navigationSystem.getNavigationStrategy().navigate(destination);
                }
                case "0" -> {
                }
                default -> System.out.println("Invalid choice");
            }
        } while (!choice.equals("0"));*/

//        Demo Visiteur
        Manager manager = new Manager();
        Developer developer = new Developer();
        Designer designer = new Designer();
        EmployeeVisitor performanceEvaluator = new PerformanceEvaluator();
        EmployeeVisitor salaryAdjuster = new SalaryAdjuster();
        performanceEvaluator.visit(manager);
        salaryAdjuster.visit(manager);

        performanceEvaluator.visit(developer);
        salaryAdjuster.visit(developer);

        performanceEvaluator.visit(designer);
        salaryAdjuster.visit(designer);
    }
}