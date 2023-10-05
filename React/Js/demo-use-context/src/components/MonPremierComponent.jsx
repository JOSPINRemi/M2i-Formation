import { useContext } from "react";
import { MonPremierContext } from "../contexts/MonPremierContext";

const MonPremierComponent = () => {
  const [value] = useContext(MonPremierContext);

  return (
    <p>
      La valeur du context est : <b>{value}</b>
    </p>
  );
};

export default MonPremierComponent;
