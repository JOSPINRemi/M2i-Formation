import { useContext, useState } from "react";
import { AppContext } from "../contexts/AppContext.js";

const TaskComponent = (props) => {
  const { STATUS } = useContext(AppContext);
  const { displayedTask } = props;
  const { task, id } = displayedTask;

  const [statusDisplay, setStatusDisplay] = useState("none");

  return (
    <div key={id}>
      <p>
        <b>{task.name}</b>
      </p>
      <p>{task.deadline.split("-").reverse().join("/")}</p>
      <p
      // style={{ display: statusDisplay}}
      >
        {task.status === STATUS[0].value ? STATUS[0].label : STATUS[1].label}
      </p>
      {/* <button
      onClick={statusDisplay === "none" ? setStatusDisplay("block") : setStatusDisplay("none")}
      >
        {statusDisplay=== "none" ? "Afficher" : "Masquer"} le status
      </button> */}
      <button type="button" style={{display: task.status === STATUS[1].value ? "block" : "none", color: "red"}}>X</button>
    </div>
  );
};

export default TaskComponent;
