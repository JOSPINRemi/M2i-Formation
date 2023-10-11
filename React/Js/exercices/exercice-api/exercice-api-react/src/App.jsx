import "./App.css";
import FormComponent from "./components/FormComponent";
import DisplayTasksListComponent from "./components/DisplayTasksListComponent";
import { useEffect, useState } from "react";
import axios from "axios";

function App() {
  const endPoint = "http://localhost:5000/todos";
  const [recoveredData, setRecoveredData] = useState([]);

  useEffect(() => {
    axios
      .get(endPoint)
      .then((response) => {
        setRecoveredData(response.data);
      })
      .catch((error) => {
        console.error("Erreur", error);
      });
  }, []);

  const addTask = (newTask) => {
    axios
      .post(endPoint, newTask)
      .then((response) => {
        console.log(response.data);
      })
      .catch((error) => {
        console.error("Erreur : ", error);
      });
  };

  return (
    <>
      <h1>ToDoList</h1>
      <FormComponent addTask={addTask} />
      <DisplayTasksListComponent recoveredData={recoveredData} />
    </>
  );
}

export default App;
