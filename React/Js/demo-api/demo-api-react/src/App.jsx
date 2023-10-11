import { useEffect } from "react";
import "./App.css";
import axios from "axios";

function App() {
  const endPoint = "http://localhost:5000/persons/";

  useEffect(() => {
    axios
      .get(endPoint)
      .then((response) => {
        console.log(response.data);
      })
      .catch((error) => {
        console.error("Erreur : ", error);
      });
  }, []);

  const addPerson = () => {
    axios
      .post(endPoint, { lastname: "Quinaux", firstname: "flore" })
      .then((response) => {
        console.log(response.data);
      })
      .catch((error) => {
        console.error("Erreur : ", error);
      });
  };

  const deletePerson = () => {
    const id = 2;
    axios
      .delete(`${endPoint}${id}`)
      .then(() => {
        console.log(`Personne avec l'id ${id} supprimée`);
      })
      .catch((error) => {
        console.error("Erreur : ", error);
      });
  };

  const updatePerson = () => {
    const id = 3;
    axios
      .put(`${endPoint}${id}`, { lastname: "Delacroix", firstname: "Pauline" })
      .then((response) => {
        console.log(response.data);
      })
      .catch((error) => {
        console.error("Erreur : ", error);
      });
  };

  return (
    <>
      <button type="button" onClick={addPerson}>
        Add
      </button>
      <button type="button" onClick={deletePerson}>
        Delete
      </button>
      <button type="button" onClick={updatePerson}>
        Update
      </button>
    </>
  );
}

export default App;
