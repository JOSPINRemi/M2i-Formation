import { useDispatch, useSelector } from "react-redux";
import { setAuthMode, setUser } from "./authSlice";
import { useRef } from "react";
import { SIGN_IN_URL, SIGN_UP_URL } from "../../fireBaseConfig";

const SignForm = () => {
  const authMode = useSelector((state) => state.auth.authMode);
  const dispatch = useDispatch();

  const emailRef = useRef();
  const passwordRef = useRef();

  const submitFormHandler = async (event) => {
    event.preventDefault();

    const email = emailRef.current.value;
    const password = passwordRef.current.value;

    const credentials = {
      email,
      password,
      returnSecureToken: true,
    };

    const URL =
      authMode === "" || authMode === "Sign in" ? SIGN_IN_URL : SIGN_UP_URL;

    try {
      const response = await fetch(URL, {
        method: "POST",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify(credentials),
      });
      if (!response.ok) {
        let errorType = authMode === "" || "Sign in" ? "Sign in" : "Sign up";
        throw new Error("Something went wrong during the " + errorType);
      }
      const data = await response.json();
      console.log(data);

      localStorage.setItem("token", data.idToken);
      dispatch(setUser(data));
    } catch (error) {
      console.error(error.message);
    }
  };

  return (
    <>
      <h3>
        {authMode === "" || authMode === "Sign in"
          ? "Se connecter"
          : "S'inscrire"}
      </h3>
      <hr />
      <form onSubmit={submitFormHandler}>
        <div>
          <label htmlFor="email">Email : </label>
          <input type="email" name="email" id="email" ref={emailRef} />
        </div>
        <div>
          <label htmlFor="password">Mot de passe : </label>
          <input
            type="password"
            name="password"
            id="password"
            ref={passwordRef}
          />
        </div>
        <button>
          {authMode === "" || authMode === "Sign in"
            ? "Se connecter"
            : "S'inscrire"}
        </button>
      </form>
      <button
        onClick={() =>
          dispatch(
            setAuthMode(
              authMode === "" || authMode === "Sign in" ? "Sign up" : "Sign in"
            )
          )
        }
      >
        {authMode === "" || authMode === "Sign in"
          ? "S'inscrire"
          : "Se connecter"}
      </button>
    </>
  );
};

export default SignForm;
