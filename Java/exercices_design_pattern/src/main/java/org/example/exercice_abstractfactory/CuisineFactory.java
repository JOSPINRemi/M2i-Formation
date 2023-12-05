package org.example.exercice_abstractfactory;

public abstract class CuisineFactory {
    abstract Ingredient createIngredient();
    abstract CookingUtensil createCookingUtensil();
    abstract Dish createDish();
}
