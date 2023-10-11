const DisplayTaskComponent = (props) => {
  const { task } = props;
  return (
    <div>
      <h3>{task.name}</h3>
    </div>
  );
};

export default DisplayTaskComponent;
