import { useRef } from "react";
import Task from "../models/Task.js";

const FormComponent = (props) => {
  const { addTask } = props;

  const nameRef = useRef();
  const formRef = useRef();

  const formHandler = (e) => {
    e.preventDefault();
    let newTask = new Task(nameRef.current.value);
    addTask(newTask);
    formRef.current.reset();
  };

  return (
    <>
      <h2>Formulaire d'ajout d'une tâche</h2>
      <form onSubmit={formHandler} ref={formRef}>
        <div>
          <label htmlFor="name">Nom : </label>
          <input type="text" id="name" ref={nameRef} required />
        </div>
        <button type="submit">Ajouter</button>
      </form>
    </>
  );
};

export default FormComponent;
