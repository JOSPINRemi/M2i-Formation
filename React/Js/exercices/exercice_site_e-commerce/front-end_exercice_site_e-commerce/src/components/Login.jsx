import { useState, useRef, useEffect } from "react";
import { useNavigate } from "react-router-dom";
import axios from "axios";

const Login = () => {
  const navigate = useNavigate();

  const [users, setUsers] = useState();

  const formRef = useRef();
  const usernameRef = useRef();
  const passwordRef = useRef();

  useEffect(() => {
    axios.get("http://localhost:5000/users").then((response) => {
      setUsers((prevState) => [...response.data]);
    });
  }, []);

  if (!users) {
    return <p>Chargement...</p>;
  }

  const formHandler = (e) => {
    e.preventDefault();
    console.log("-bouton appuyé-");
    users.map((user) => {
      if (
        user.username === usernameRef.current.value &&
        user.password === passwordRef.current.value
      ) {
        if (user.status === "admin") {
          localStorage.setItem("isLoggedIn", true);
          formRef.current.reset();
          navigate("/add");
        } else {
          alert("You're no an admin");
        }
      }
    });
  };

  return (
    <>
      <h2>Login page</h2>
      <form onSubmit={formHandler} ref={formRef}>
        <div>
          <label htmlFor="username">Username : </label>
          <input type="text" name="username" id="username" ref={usernameRef} />
        </div>
        <div>
          <label htmlFor="password">Password : </label>
          <input
            type="password"
            name="password"
            id="password"
            ref={passwordRef}
          />
        </div>
        <button type="submit">Login</button>
      </form>

      {/* {console.log(users)} */}
    </>
  );
};

export default Login;
