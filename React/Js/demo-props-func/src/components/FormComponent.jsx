import { useState } from "react";

const FormComponent = (props) => {
  const { loginHandler } = props;

  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");

  const submitHandler = (event) => {
    event.preventDefault();
    loginHandler({ username, password });
  };

  return (
    <form action="#" onSubmit={submitHandler}>
      <div>
        <label htmlFor="username">Username : </label>
        <input
          type="text"
          id="username"
          value={username}
          onInput={(e) => setUsername(e.target.value)}
        />
      </div>
      <div>
        <label htmlFor="password">Password : </label>
        <input
          type="password"
          id="password"
          value={password}
          onInput={(e) => setPassword(e.target.value)}
        />
      </div>
      <button>Submit</button>
    </form>
  );
};

export default FormComponent;
