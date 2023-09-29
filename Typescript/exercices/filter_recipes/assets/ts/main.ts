import { recipes } from "./data/recipes.js";

// TODO: Ajouter les onChange sur les input et le select
const main = document.querySelector("#main") as HTMLElement;
const inputName = document.querySelector("#name") as HTMLInputElement;
const selectIngredients = document.querySelector(
  "#ingredients"
) as HTMLSelectElement;
const preparationTimeValue = document.querySelector(
  "#preparationTimeValue"
) as HTMLElement;
const preparationTimeRange = document.querySelector(
  "#preparationTime"
) as HTMLInputElement;
const cookingTimeValue = document.querySelector(
  "#cookingTimeValue"
) as HTMLElement;
const cookingTimeRange = document.querySelector(
  "#cookingTime"
) as HTMLInputElement;
const ingredientsSelect = document.querySelector(
  "#ingredients"
) as HTMLSelectElement;

const recipesList: Recipe[] = [];
let ingredientsList: string[] = [];

// console.log(recipes);
// let ingredient: Recipe = recipes[0].name;
// console.log(ingredient);

for (const key in recipes) {
  // console.log(key);
  recipesList.push(recipes[key]);
}

renderAside();

function renderAside() {
  preparationTimeValue.textContent = preparationTimeRange.value;
  cookingTimeValue.textContent = cookingTimeRange.value;
  let ingredientOption = document.createElement("option");
  ingredientOption.textContent = "--Select ingredient in list--";
  ingredientOption.selected = true;
  ingredientsSelect.appendChild(ingredientOption);
  recipesList.forEach((recipe) => {
    recipe.ingredients.forEach((ingredient) => {
      let ingredientName = ingredient.name;
      if (!ingredientsList.includes(ingredientName)) {
        ingredientsList.push(ingredientName);
        ingredientOption = document.createElement("option");
        ingredientOption.textContent = ingredientName;
        ingredientsSelect.appendChild(ingredientOption);
      }
    });
  });
  let preparationTimeRangeValue = preparationTimeRange.value;
  let cookingTimeRangeValue = cookingTimeRange.value;
  let preparationTimeRangeValueNumber = parseInt(preparationTimeRangeValue);
  let cookingTimeRangeValueNumber = parseInt(cookingTimeRangeValue);
  let inputNameValue = inputName.value.trim();
  let selectedIngredients =
    selectIngredients.options[selectIngredients.selectedIndex];
  let selectedIngredientsValue = selectIngredients.value;
  renderMain(
    preparationTimeRangeValueNumber,
    cookingTimeRangeValueNumber,
    inputNameValue,
    selectedIngredientsValue
  );
}

function renderMain(
  preparationTimeRangeValueNumber: number,
  cookingTimeRangeValueNumber: number,
  inputNameValue: string,
  selectedIngredientsValue: string
) {
  recipesList.forEach((recipe) => {
    let prepTimeNumber = parseInt(recipe.prepTime);
    let cookTimeNumber = parseInt(recipe.cookTime);
    if (
      prepTimeNumber <= preparationTimeRangeValueNumber &&
      cookTimeNumber <= cookingTimeRangeValueNumber
    ) {
      // Item of list
      let recipeItem = document.createElement("div");
      if (
        inputNameValue === "" &&
        selectedIngredientsValue === "--Select ingredient in list--"
      ) {
        recipeItem.classList.add("recipeItem");

        // Name of recipe
        let recipeName = document.createElement("h3");
        recipeName.textContent = recipe.name;
        recipeName.classList.add("recipeName");
        recipeItem.appendChild(recipeName);

        let hr = document.createElement("hr");
        recipeItem.appendChild(hr);

        // Times of recipe
        // Prep time of recipe
        let recipeTimes = document.createElement("div");
        recipeTimes.classList.add("recipeTimes");
        let recipePrepTime = document.createElement("p");
        recipePrepTime.textContent = recipe.prepTime;
        recipeTimes.appendChild(recipePrepTime);
        // Cook time of recipe
        let recipeCookTime = document.createElement("p");
        recipeCookTime.textContent = recipe.cookTime;
        recipeTimes.appendChild(recipeCookTime);
        recipeItem.appendChild(recipeTimes);
      } else {
        if (inputNameValue !== "" && recipe.name.includes(inputNameValue)) {
          recipeItem.classList.add("recipeItem");

          // Name of recipe
          let recipeName = document.createElement("h3");
          recipeName.textContent = recipe.name;
          recipeName.classList.add("recipeName");
          recipeItem.appendChild(recipeName);

          let hr = document.createElement("hr");
          recipeItem.appendChild(hr);

          // Times of recipe
          // Prep time of recipe
          let recipeTimes = document.createElement("div");
          recipeTimes.classList.add("recipeTimes");
          let recipePrepTime = document.createElement("p");
          recipePrepTime.textContent = recipe.prepTime;
          recipeTimes.appendChild(recipePrepTime);
          // Cook time of recipe
          let recipeCookTime = document.createElement("p");
          recipeCookTime.textContent = recipe.cookTime;
          recipeTimes.appendChild(recipeCookTime);
          recipeItem.appendChild(recipeTimes);
        } else if (selectedIngredientsValue !== "") {
          recipe.ingredients.forEach((ingredient) => {
            ingredient.name.includes(selectedIngredientsValue);
          });
        }
      }
      main.appendChild(recipeItem);
    }
  });
}
