import RecipeForm from "./RecipeForm";

const RecipesList = (props) => {
  const user = props.user;

  return (
    <>
      <h3>Recipes List</h3>
      <button
        type="button"
        className="btn btn-success"
        data-bs-toggle="modal"
        data-bs-target="#staticBackdrop"
      >
        Add
      </button>
      <hr />
      <RecipeForm user={user} />
    </>
  );
};

export default RecipesList;
