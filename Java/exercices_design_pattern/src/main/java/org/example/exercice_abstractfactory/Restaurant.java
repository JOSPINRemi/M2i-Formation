package org.example.exercice_abstractfactory;

public class Restaurant {
    private CuisineFactory cuisineFactory;
    private Ingredient ingredient;
    private CookingUtensil cookingUtensil;
    private Dish dish;

    public Restaurant(CuisineFactory cuisineFactory) {
        this.setCuisineFactory(cuisineFactory);
    }

    public void setCuisineFactory(CuisineFactory cuisineFactory) {
        this.cuisineFactory = cuisineFactory;
        this.ingredient = this.cuisineFactory.createIngredient();
        this.cookingUtensil = this.cuisineFactory.createCookingUtensil();
        this.dish = this.cuisineFactory.createDish();
    }

    public void runPlate(){
        ingredient.prepare();
        cookingUtensil.use();
        dish.serve();
    }
}
