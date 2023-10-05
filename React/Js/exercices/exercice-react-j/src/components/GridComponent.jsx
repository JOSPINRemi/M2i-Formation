import { useContext } from "react";
import { AppContext } from "../contexts/AppContext";
import style from "../assets/styles/GridComponentStyle.module.css";

const GridComponent = () => {
  const { dogs } = useContext(AppContext);

  return (
    <main className={style.grid}>
      {dogs.map((dog, id) => (
        <div key={id} className={style.card}>
          <img
            src={dog.pictureUrl}
            alt={"chien " + dog.breed + " " + dog.name}
          />
          <p>{dog.name}</p>
          <button>Détails</button>
        </div>
      ))}
    </main>
  );
};

export default GridComponent;
