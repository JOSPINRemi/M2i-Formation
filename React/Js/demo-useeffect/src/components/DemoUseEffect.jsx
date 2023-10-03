import { useState, useEffect } from "react";

const DemoUseEffect = () => {
  //   const [counter, setCounter] = useState(0);
  //   const [counterFormat, setCounterFormat] = useState("0");

  //   const changeCounterValue = (event) => {
  //     const counterValue = +event.target.value;
  //     setCounter(counterValue);
  //   };

  //   useEffect(() => {
  //     setCounterFormat(`${counter}`);
  //   }, [counter]);

  //   useEffect(() => {
  //     setCounterFormat(`02`);
  //   }, []);

  //   return (
  //     <>
  //       <input type="text" value={counterFormat} onInput={changeCounterValue} />
  //     </>
  //   );

  const [firstname, setFirstname] = useState("");
  const [lastname, setLastname] = useState("");
  const [fullname, setFullname] = useState("");

  const firstnameInputChanged = (e) => {
    setFirstname(e.target.value);
  };

  const lastnameInputChanged = (e) => {
    setLastname(e.target.value);
  };

  useEffect(() => {
    setFullname(firstname + " " + lastname);
  }, [firstname, lastname]);

  return (
    <>
      <input type="text" value={firstname} onInput={firstnameInputChanged} />
      <input type="text" value={lastname} onInput={lastnameInputChanged} />
      <p>{fullname}</p>
    </>
  );
};

export default DemoUseEffect;
