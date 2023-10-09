import { useContext, useEffect, useRef, useState } from "react";
import styles from "../assets/styles/FormComponentStyles.module.css";
import { AppContext } from "../contexts/AppContext.js";

const FormComponent = () => {
  const { setTasks, STATUS } = useContext(AppContext);

  const formRef = useRef();
  const taskNameRef = useRef();
  const deadLineRef = useRef();
  const statusRef = useRef();

  const [addTaskBtnDisabledStatus, setAddTaskBtnDisabledStatus] =
    useState(true);

  useEffect(() => {
    console.log("Vérification des informations saisies");
    if (
      taskNameRef.current?.value.trim() !== "" &&
      deadLineRef.current?.value.trim() !== "" &&
      statusRef.current?.value.trim() !== ""
    ) {
      console.log("Vous pouvez ajouter les informations");
      setAddTaskBtnDisabledStatus(false);
    }
    return () => {
      // console.clear();
    };
  }, [
    taskNameRef.current?.value,
    deadLineRef.current?.value,
    statusRef.current?.value,
  ]);

  const submitFormHandler = (event) => {
    event.preventDefault();

    const taskName = taskNameRef.current.value;
    const deadLine = new Date(deadLineRef.current.value);
    const status = statusRef.current.value;

    const newTask = {
      name: taskName,
      deadline: deadLine,
      status: status,
    };

    setTasks((prevTasks) => [...prevTasks, newTask]);

    console.group("Une tâche a été ajoutée");
    console.log("Détails de la tâche");
    console.table(newTask);
    console.groupEnd();

    setTimeout(() => {
      formRef.current.reset();
      setAddTaskBtnDisabledStatus(true);
    }, 2000);
  };

  return (
    <div className={styles.monStyle}>
      <h1>Formulaire de création de tâche</h1>
      <form onSubmit={submitFormHandler} ref={formRef}>
        <div>
          <label htmlFor="taskName">Nom : </label>
          <input
            type="text"
            name="taskName"
            id="taskName"
            ref={taskNameRef}
            placeholder="ex: Aller acheter du pain"
            required
          />
        </div>
        <div>
          <label htmlFor="deadLine">Échéance : </label>
          <input
            type="date"
            name="deadLine"
            id="deadLine"
            ref={deadLineRef}
            required
          />
        </div>
        <div>
          <label htmlFor="status">Statut : </label>
          <select name="status" id="status" ref={statusRef} required>
            <option value="" key="">
              Choisir un statut
            </option>
            {STATUS.map((status, id) => (
              <option key={id} value={status.value}>
                {status.label}
              </option>
            ))}
          </select>
        </div>
        <button disabled={addTaskBtnDisabledStatus}>Ajouter une tâche</button>
      </form>
    </div>
  );
};

export default FormComponent;
