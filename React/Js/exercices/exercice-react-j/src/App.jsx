import { useState } from "react";
import { AppContext } from "./contexts/AppContext";
import FormComponent from "./components/FormComponent";
import GridComponent from "./components/GridComponent";

function App() {
  const [dogs, setDogs] = useState([]);

  return (
    <AppContext.Provider value={{ dogs: dogs, setDogs: setDogs }}>
      <h1>Adopte un chien</h1>
      <FormComponent />
      <GridComponent />
    </AppContext.Provider>
  );
}

export default App;
