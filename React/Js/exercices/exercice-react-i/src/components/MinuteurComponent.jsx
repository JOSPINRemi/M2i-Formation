import { useState } from "react";

const MinuteurComponent = () => {
  const [counter, setCounter] = useState(10);
  let intervalId;

  const startMinuteur = () => {
    intervalId = setInterval(() => {
      getTime();
    }, 1000);
  };

  const getTime = () => {
    if (counter > 0) {
      setCounter(counter - 1);
      console.log(counter);
    } else if (counter == 0) {
      clearInterval(intervalId);
    }
  };

  return (
    <div>
      <button onClick={startMinuteur}>Start</button>
    </div>
  );
};

export default MinuteurComponent;
