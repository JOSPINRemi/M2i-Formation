import { useContext, useState } from "react";
import { AppContext } from "../contexts/AppContext";

const FormComponent = () => {
  const { setDogs } = useContext(AppContext);

  const [name, setName] = useState("");
  const [breed, setBreed] = useState("");
  const [dateOfBirth, setDateOfBirth] = useState("");
  const [pictureUrl, setPictureUrl] = useState("");

  const submitHandler = (event) => {
    event.preventDefault();
    let dog = {
      name: name,
      breed: breed,
      dateOfBith: dateOfBirth,
      pictureUrl: pictureUrl,
    };
    setDogs((prevState) => [...prevState, dog]);
  };

  return (
    <aside>
      <form onSubmit={submitHandler}>
        <div>
          <label htmlFor="name">Nom : </label>
          <input
            type="text"
            name="name"
            id="name"
            value={name}
            onInput={(e) => setName(e.target.value)}
          />
        </div>

        <div>
          <label htmlFor="breed">Race : </label>
          <input
            type="text"
            name="breed"
            id="breed"
            value={breed}
            onInput={(e) => setBreed(e.target.value)}
          />
        </div>

        <div>
          <label htmlFor="dateOfBirth">Date de naissance : </label>
          <input
            type="date"
            name="dateOfBirth"
            id="dateOfBirth"
            value={dateOfBirth}
            onInput={(e) => setDateOfBirth(e.target.value)}
          />
        </div>
        <div>
          <label htmlFor="picture">Picture url : </label>
          <input
            type="text"
            name="picture"
            id="picture"
            value={pictureUrl}
            onInput={(e) => setPictureUrl(e.target.value)}
          />
        </div>

        <button type="submit" id="addBtn">
          Ajouter
        </button>
      </form>
    </aside>
  );
};

export default FormComponent;
