import { useState } from "react";
import MonPremierComponent from "./components/MonPremierComponent";
import { MonPremierContext } from "./contexts/MonPremierContext";
import InputComponent from "./components/InputComponent";
import DemoUseMemo from "./components/DemoUseMemo";

function App() {
  const mastate = useState("titi");

  return (
    <MonPremierContext.Provider value={mastate}>
      <h1>App</h1>
      <hr />
      <InputComponent />
      <hr />
      <MonPremierComponent />
      <hr />
      <DemoUseMemo />
    </MonPremierContext.Provider>
  );
}

export default App;
