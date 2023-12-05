package org.example.exercice_abstractfactory;

public class JapaneseCuisineFactory extends CuisineFactory {
    @Override
    Ingredient createIngredient() {
        return new JapaneseIngredient();
    }

    @Override
    CookingUtensil createCookingUtensil() {
        return new JapaneseCookingUtensil();
    }

    @Override
    Dish createDish() {
        return new JapaneseDish();
    }
}
