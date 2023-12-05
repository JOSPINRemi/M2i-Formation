package org.example.exercice_abstractfactory;

public class JapaneseIngredient extends Ingredient {
    @Override
    void prepare() {
        System.out.println("Japanese ingredient is prepared");
    }
}
