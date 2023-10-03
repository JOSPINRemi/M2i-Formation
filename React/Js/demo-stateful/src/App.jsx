import { useState } from "react";
import FirstStatefulComponent from "./components/FirstStatefulComponent";

function App() {
const [compVisibility, setCompVisibility] = useState()

  return (
    <div className="App">
      <button onClick={() => setCompVisibility(!compVisibility)}>Toggle FirstStatefulComponent</button>
      <button onClick={() => setCompVisibility(!compVisibility)}>Toggle FirstHookComponent</button>
      <FirstStatefulComponent />
    </div>
  );
}

export default App;
