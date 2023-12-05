package org.example.exercice_abstractfactory;

public class MexicanIngredient extends Ingredient {
    @Override
    void prepare() {
        System.out.println("Mexican ingredient is prepared");
    }
}
