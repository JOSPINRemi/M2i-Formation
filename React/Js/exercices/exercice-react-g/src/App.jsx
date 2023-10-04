import { useState } from "react";
import DisplayComponent from "./components/DisplayComponent";
import FormComponent from "./components/FormComponent";

function App() {
  const [users, setUsers] = useState([]);

  return (
    <div className="App">
      <FormComponent
        addUser={(newUser) => setUsers((prevState) => [...prevState, newUser])}
      />
      <DisplayComponent users={users} />
    </div>
  );
}

export default App;
