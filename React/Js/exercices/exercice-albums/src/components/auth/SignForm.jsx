import { useDispatch, useSelector } from "react-redux";
import { setUser, setAuthMode } from "./authSlice";
import { useRef } from "react";
import { SIGN_UP_URL, SIGN_IN_URL } from "../../fireBaseConfig";

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

    const URL = authMode === "Se connecter" ? SIGN_IN_URL : SIGN_UP_URL;

    dispatch(setUser({ url: URL, credentials: credentials }));
    dispatch(setAuthMode(""));
  };

  return (
    <>
      <h3>{authMode === "Sign in" ? "Se connecter" : "S'inscrire"}</h3>
      <hr />
      <form onSubmit={submitFormHandler}>
        <div>
          <label htmlFor="email">Email: </label>
          <input type="email" id="email" ref={emailRef} />
        </div>
        <div>
          <label htmlFor="password">Password: </label>
          <input type="password" id="password" ref={passwordRef} />
        </div>
        <button>
          {authMode === "Sign in" ? "Se connecter" : "S'inscrire"}
        </button>
      </form>
      <button
        onClick={() =>
          dispatch(setAuthMode(authMode === "Sign in" ? "Sign up" : "Sign in"))
        }
      >
        {authMode === "Sign in" ? "S'inscrire" : "Se connecter"}
      </button>
    </>
  );
};

export default SignForm;
