import { configureStore } from "@reduxjs/toolkit";
import autSlice from "./components/auth/authSlice";
import recipeSlice from "./components/recipes/recipeSlice";

export default configureStore({
  reducer: {
    auth: autSlice,
    recipe: recipeSlice,
  },
});
