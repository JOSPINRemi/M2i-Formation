import { useState } from "react";

const FormComponent = (props) => {
  const { addUser } = props;

  const [firstName, setFirstName] = useState("");
  const [lastName, setLastName] = useState("");
  const [birthDate, setBirthDate] = useState("");

  const submitHandler = (event) => {
    event.preventDefault();
    let user = {
      lastname: lastName,
      firstname: firstName,
      birthdate: birthDate,
    };
    console.log("submithandler " + user);
    addUser(user);
  };

  return (
    <form action="#" onSubmit={submitHandler}>
      <div>
        <label htmlFor="firstname">Firstname : </label>
        <input
          type="text"
          id="firstname"
          value={firstName}
          onInput={(e) => setFirstName(e.target.value)}
        />
      </div>
      <div>
        <label htmlFor="lastname">Lastname : </label>
        <input
          type="text"
          id="lastname"
          value={lastName}
          onInput={(e) => setLastName(e.target.value)}
        />
      </div>
      <div>
        <label htmlFor="birthDate">Date of Birth : </label>
        <input
          type="date"
          id="birthDate"
          value={birthDate}
          onInput={(e) => setBirthDate(e.target.value)}
        />
      </div>
      <button type="submit">Submit</button>
    </form>
  );
};

export default FormComponent;
