package org.example.exercice_abstractfactory;

public class ItalianIngredient extends Ingredient {
    @Override
    void prepare() {
        System.out.println("Italian ingredient is prepared");
    }
}
