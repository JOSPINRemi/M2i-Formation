import { useState } from "react";

const InputComponent = () => {
  const [person, setPerson] = useState({
    lastname: "",
    firstname: "",
  });

  const changeLastname = (event) => {
    setPerson((prevState) => ({ ...prevState, lastname: event.target.value }));
  };

  const changeFirstname = (event) => {
    setPerson((prevState) => ({ ...prevState, firstname: event.target.value }));
  };

  return (
    <>
      <div>
        <label htmlFor="lastName">Nom : </label>
        <input
          type="text"
          id="lastName"
          value={person.lastname}
          onInput={changeLastname}
        />
      </div>
      <div>
        <label htmlFor="firstName">Prénom : </label>
        <input
          type="text"
          id="firstName"
          value={person.firstname}
          onInput={changeFirstname}
        />
      </div>
      <p>
        Bonjour{" "}
        <b>
          {person.firstname.charAt(0).toUpperCase()}
          {person.firstname.slice(1)} {person.lastname.toUpperCase()}
        </b>
        , bienvenue dans l'application !
      </p>
    </>
  );
};

export default InputComponent;
