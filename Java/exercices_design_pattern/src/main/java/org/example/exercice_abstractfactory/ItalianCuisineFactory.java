package org.example.exercice_abstractfactory;

public class ItalianCuisineFactory extends CuisineFactory {
    @Override
    Ingredient createIngredient() {
        return new ItalianIngredient();
    }

    @Override
    CookingUtensil createCookingUtensil() {
        return new ItalianCookingUtensil();
    }

    @Override
    Dish createDish() {
        return new ItalianDish();
    }
}
