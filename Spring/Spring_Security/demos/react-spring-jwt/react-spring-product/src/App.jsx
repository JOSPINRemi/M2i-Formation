import { useState } from "react";
import reactLogo from "./assets/react.svg";
import viteLogo from "/vite.svg";
import "./App.css";
import { Router } from "react-router-dom";
import Header from "./shared/Header";

function App() {
  const [count, setCount] = useState(0);

  return (
    <Router>
      <Header />
    </Router>
  );
}

export default App;
