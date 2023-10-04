import { useRef } from "react";

const LoginComponent = (props) => {
  const { displayInfos } = props;

  const lastnameRef = useRef();
  const firstnameRef = useRef();

  const displayFormInfos = (...args) => {
    displayInfos(args);
  };

  return (
    <form>
      <div>
        <label htmlFor="lastname">Lastname : </label>
        <input type="text" id="lastname" ref={lastnameRef} />
      </div>
      <div>
        <label htmlFor="firtsname">Firstname : </label>
        <input type="text" id="lastname" ref={firstnameRef} />
      </div>
      <button
        type="button"
        onClick={() =>
          displayFormInfos(
            lastnameRef.current?.value,
            firstnameRef.current?.value
          )
        }
      >
        Login
      </button>
    </form>
  );
};

export default LoginComponent;
