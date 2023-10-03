import { useEffect } from "react";
import { useState } from "react";

const FindMysteryValueComponent = (props) => {
  const [inputA, setInputA] = useState(0);
  const [inputB, setInputB] = useState(0);
  const [isWon, setIsWon] = useState(false);

  const nbAHandler = (event) => {
    setInputA(+event.target.value);
  };

  const nbBHandler = (event) => {
    setInputB(+event.target.value);
  };

  useEffect(() => {
    if (inputA * inputB == props.mysteryValue) {
      setIsWon(true);

      console.log(`${isWon}`);
    }
  }, [inputA, inputB]);

  return (
    <>
      <div>
        <div>
          <label htmlFor="nbA">nbA : </label>
          <input type="number" id="nbA" value={inputA} onInput={nbAHandler} />
        </div>
        <div>
          <label htmlFor="nbB">nbB : </label>
          <input type="number" id="nbB" value={inputB} onInput={nbBHandler} />
        </div>
      </div>
      <div>
        <p>
          {isWon
            ? "Félicitations"
            : `${inputA} x ${inputB} != ${props.mysteryValue}`}
        </p>
      </div>
    </>
  );
};

export default FindMysteryValueComponent;
