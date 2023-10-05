import { useState, useEffect } from "react";

const MinuteurComponent = () => {
  const [counter, setCounter] = useState(10);
  let intervalId = undefined;

  const startMinuteur = () => {
    setTimeout(() => {
      setCounter(counter - 1);
    }, 1000);
  };

  useEffect(() => {
    intervalId = setInterval(() => {
      setCounter(counter - 1);
    }, 1000);

    if (counter > 0) {
      console.log("--- Counter Updated ---");
      console.log(counter);
    } else if (counter === 0) {
      if (intervalId) {
        clearInterval(intervalId);
      }
    }
  }, [counter]);

  return (
    <div>
      <p>{counter}</p>
      <button type="button" onClick={startMinuteur}>
        Start
      </button>
    </div>
  );
};

export default MinuteurComponent;
