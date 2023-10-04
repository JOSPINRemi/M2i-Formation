import { useState } from "react";
import ChildComponent from "./ChildComponent";
import FormComponent from "./FormComponent";

const ParentComponent = () => {
  const [maState, setMaState] = useState("");

  const sayHello = () => {
    console.log("Hello world form ParentComponent");
  };

  const loginHandler = ({ username, password }) => {
    console.log("Parentcomponent");
    console.log("username : " + username);
    console.log("password : " + password);
  };

  const maVariable = "toto";

  return (
    <>
      <h1>Parent Component</h1>
      <hr />
      <p>Dans le parent, maState {maState}</p>
      <ChildComponent
        maProp="titi"
        maPropB={maVariable}
        maFonction={sayHello}
        setMaState={setMaState}
      />
      <hr />
      <FormComponent loginHandler={loginHandler} />
    </>
  );
};

export default ParentComponent;
