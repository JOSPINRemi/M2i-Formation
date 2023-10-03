import { useState, useEffect } from "react";

const DemoUseEffectBis = () => {
  const [inputValue, setInputValue] = useState("");
  const [isInputValide, setIsInputValide] = useState(false);

  const inputChangeHandler = (event) => {
    setInputValue(event.target.value);
  };

  useEffect(() => {
    console.log("RENDER");

    console.log("Mise en attente d'un appel API");

    let timer = setTimeout(() => {
      console.log("Appel API résolu");
      setIsInputValide(inputValue === "John");
    }, 4000);

    return () => {
      console.log("UNMOUNT");

      if (timer) {
        console.log("Annulation du précédent appel API");

        clearTimeout(timer);
        timer = undefined;
      }
    };
  }, [inputValue]);

  return (
    <>
      <input type="text" value={inputValue} onInput={inputChangeHandler} />
      <hr />
      <p>
        Mon input est <b>{isInputValide ? "Valide" : "Invalide"}</b>
      </p>
    </>
  );
};

export default DemoUseEffectBis;
