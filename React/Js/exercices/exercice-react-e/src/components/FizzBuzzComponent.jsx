import { useState } from "react";

const FizzBuzzComponent = (props) => {
  const [counter, setCounter] = useState(0);
  const maxInt = parseInt(props.max);
  let message = "";

  if (counter % 3 === 0 && counter % 5 === 0) {
    message = "FizzBuzz";
  } else if (counter % 3 === 0) {
    message = "Fizz";
  } else if (counter % 5 === 0) {
    message = "Buzz";
  } else {
    message = counter;
  }

  if (counter <= 0) {
    return (
      <>
        <p>{message}</p>
        <button
          type="button"
          onClick={() => setCounter(counter - 1)}
          disabled={true}
        >
          -
        </button>
        <button
          type="button"
          onClick={() => setCounter(counter + 1)}
          disabled={false}
        >
          +
        </button>
      </>
    );
  } else if (counter >= maxInt) {
    return (
      <>
        <p>{message}</p>
        <button
          type="button"
          onClick={() => setCounter(counter - 1)}
          disabled={false}
        >
          -
        </button>
        <button
          type="button"
          onClick={() => setCounter(counter + 1)}
          disabled={true}
        >
          +
        </button>
      </>
    );
  } else {
    return (
      <>
        <p>{message}</p>
        <button type="button" onClick={() => setCounter(counter - 1)}>
          -
        </button>
        <button type="button" onClick={() => setCounter(counter + 1)}>
          +
        </button>
      </>
    );
  }
};

export default FizzBuzzComponent;
