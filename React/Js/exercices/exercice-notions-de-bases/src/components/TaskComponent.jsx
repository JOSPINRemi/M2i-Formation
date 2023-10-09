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
      <p>{task.deadline.toLocaleDateString()}</p>
      <p
      // style={{ display: statusDisplay}}
      >
        {task.status === STATUS[0].value ? STATUS[0].label : STATUS[1].label}
        {/* {STATUS.map((elementStatus) => {
          elementStatus.value === task.status && <span>{elementStatus.label}</span>;
        })} */}
      </p>
      {/* <button
      onClick={statusDisplay === "none" ? setStatusDisplay("block") : setStatusDisplay("none")}
      >
        {statusDisplay=== "none" ? "Afficher" : "Masquer"} le status
      </button> */}

      {task.status === STATUS[1].value && (
        <button
          type="button"
          style={{
            color: "red",
          }}
        >
          X
        </button>
      )}
    </div>
  );
};

export default TaskComponent;
