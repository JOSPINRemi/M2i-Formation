import { useState } from "react";
import { AppContext } from "./contexts/AppContext.js";
import FormComponent from "./components/FormComponent.jsx";
import TaskComponent from "./components/TaskComponent.jsx";

function App() {
  const [tasks, setTasks] = useState([]);
  const STATUS = [
    {
      value: "inProgress",
      label: "En cours",
    },
    {
      value: "over",
      label: "Finie",
    },
  ];
  return (
    <AppContext.Provider value={{setTasks, STATUS}}>
      <FormComponent />
      {tasks.map((task, id) => (
        <TaskComponent key={id} />
        // <button type="button" value={task.status === 'inProgess' ? 'inProgess' : 'over'} onClick={setTasks(prevState => ([...prevState]))}>{task.status === 'inProgess' ? 'En cours' : 'Finie'}</button>
      ))}
    </AppContext.Provider>
  );
}

export default App;
