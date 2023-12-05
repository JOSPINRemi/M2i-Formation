package org.example.exercice_abstractfactory;

public class MexicanCuisineFactory extends CuisineFactory {
    @Override
    Ingredient createIngredient() {
        return new MexicanIngredient();
    }

    @Override
    CookingUtensil createCookingUtensil() {
        return new MexicanCookingUtensil();
    }

    @Override
    Dish createDish() {
        return new MexicanDish();
    }
}
