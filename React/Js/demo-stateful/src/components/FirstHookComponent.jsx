import { useState } from "react";

const FirstHookComponent = (props) => {
  // const [monPrenom, setMonPrenom] = useState(props.monPrenom)
  const [monPrenom, setMonPrenom] = useState("Antoine");

  return (
    <>
      <h1>FirstStatefulComponent</h1>
      <hr />
      <p>Mon prénom est {this.state.monPrenom}</p>
      <button onClick={() => setMonPrenom("Titi")}>Change firstname</button>
    </>
  );
};

export default FirstHookComponent;
