import { recipes } from "./data/recipes.js";

const main = document.querySelector("#main") as HTMLElement;
const aside = document.querySelector("#aside") as HTMLElement;

const recipesList: Recipe[] = [];

console.log(recipes);
let ingredient: Recipe = recipes[0].name;
console.log(ingredient);
