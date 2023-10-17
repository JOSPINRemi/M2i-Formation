import { useRef } from "react";
import { useDispatch } from "react-redux";
import { addRecipe } from "../recipes/recipeSlice";
import { BASE_DB_URL } from "../../fireBaseConfig";

const RecipeForm = (props) => {
  const titleRef = useRef();
  const instructionsRef = useRef();
  const cookTimeRef = useRef();
  const prepTimeRef = useRef();
  const ingredientsRef = useRef();

  const user = props.user;
  
  const dispatch = useDispatch();

  const handleFormSubmit = async (event) => {
    event.preventDefault();

    const newRecipe = {
      id: Date.now(),
      title: titleRef.current.value,
      instructions: instructionsRef.current.value,
      cookTime: cookTimeRef.current.value,
      prepTime: prepTimeRef.current.value,
      ingredients: ingredientsRef.current.value,
    };

    if (user.idToken) {
      try {
        const response = await fetch(
          `${BASE_DB_URL}/recipeList.json?auth=${user.idToken}`,
          {
            method: "POST",
            headers: {
              "Content-Type": "application/json",
            },
            body: JSON.stringify(newRecipe),
          }
        );

        if (!response.ok) {
          throw new Error("Something went wrong during the POST request !");
        }

        const data = await response.json();

        console.log(data);
        dispatch(addRecipe(newRecipe));
      } catch (error) {
        console.error(error.message);
      }
    }
  };

  return (
    <>
      <form onSubmit={handleFormSubmit}>
        <div
          className="modal fade"
          id="staticBackdrop"
          data-bs-backdrop="static"
          data-bs-keyboard="false"
          tabIndex="-1"
          aria-labelledby="staticBackdropLabel"
          aria-hidden="true"
        >
          <div className="modal-dialog modal-dialog-centered">
            <div className="modal-content">
              <div className="modal-header">
                <h1 className="modal-title fs-5" id="staticBackdropLabel">
                  Add Recipe
                </h1>
                <button
                  type="button"
                  className="btn-close"
                  data-bs-dismiss="modal"
                  aria-label="Close"
                ></button>
              </div>
              <div className="modal-body">
                <div className="mb-3 form-floating">
                  <input
                    type="text"
                    name="recipeName"
                    id="recipeName"
                    className="form-control"
                    ref={titleRef}
                    placeholder=""
                  />
                  <label htmlFor="recipeName">Nom de la recette</label>
                </div>
                <div className="mb-3 form-floating">
                  <textarea
                    name="recipeInstructions"
                    id="recipeInstructions"
                    className="form-control"
                    cols="30"
                    rows="10"
                    ref={instructionsRef}
                    placeholder=""
                  ></textarea>
                  <label htmlFor="recipeInstructions">Instructions</label>
                </div>
                <div className="mb-3 form-floating">
                  <input
                    type="number"
                    name="recipeCookTime"
                    id="recipeCookTime"
                    className="form-control"
                    ref={cookTimeRef}
                    placeholder=""
                  />
                  <label htmlFor="recipeCookTime">Temps de cuisson</label>
                </div>
                <div className="mb-3 form-floating">
                  <input
                    type="number"
                    name="recipePrepTime"
                    id="recipePrepTime"
                    className="form-control"
                    ref={prepTimeRef}
                    placeholder=""
                  />
                  <label htmlFor="recipePrepTime">Temps de préparation</label>
                </div>
                <div className="mb-3 form-floating">
                  <input
                    type="text"
                    name="recipeIngredients"
                    id="recipeIngredients"
                    className="form-control"
                    ref={ingredientsRef}
                    placeholder=""
                  />
                  <label htmlFor="recipeIngredients">Ingrédients</label>
                </div>
              </div>
              <div className="modal-footer">
                <button
                  type="button"
                  className="btn btn-danger"
                  data-bs-dismiss="modal"
                >
                  Close
                </button>
                <button type="submit" className="btn btn-success">
                  Add
                </button>
              </div>
            </div>
          </div>
        </div>
      </form>
    </>
  );
};

export default RecipeForm;
