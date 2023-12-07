package org.example;

import org.example.exercice_abstractfactory.ItalianCuisineFactory;
import org.example.exercice_abstractfactory.JapaneseCuisineFactory;
import org.example.exercice_abstractfactory.Restaurant;
import org.example.exercice_builder.Pizza;
import org.example.exercice_observable.Product;
import org.example.exercice_observable.StockManager;
import org.example.exercice_observable.Supplier;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
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
        Product product = new Product(10);
        StockManager stockManager = new StockManager();
        Supplier supplier = new Supplier();
        product.registerObserver(stockManager);
        product.registerObserver(supplier);

        product.setStockLevel(15);

        product.removeObserver(supplier);
        product.setStockLevel(16);
    }
}