import { useState } from "react";

const ListingComponent = () => {
  const [elementsList, setElementsList] = useState([]);
  const [counter, setCounter] = useState(0);

  return (
    <>
      <button
        onClick={() => {
          setElementsList([...elementsList, "Element " + counter]);
          setCounter(counter + 1);
        }}
      >
        Ajouter un élément
      </button>
      <hr />
      <ul>
        {elementsList.map((element, index) => (
          <li key={index}>{element}</li>
        ))}
      </ul>
    </>
  );
};

export default ListingComponent;
