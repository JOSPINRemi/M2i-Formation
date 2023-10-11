import DisplayTaskComponent from "./DisplayTaskComponent";

const DisplayTasksListComponent = (props) => {
  const { recoveredData } = props;

  return (
    <>
      <h2>Tâches</h2>
      {recoveredData === undefined
        ? "La liste est undefined"
        : recoveredData.length == 0
        ? "Il n'y a pas de tâche"
        : recoveredData.map((task) => (
            <DisplayTaskComponent key={task.id} task={task} />
          ))}
    </>
  );
};

export default DisplayTasksListComponent;
