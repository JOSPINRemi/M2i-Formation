const AlertBootstrapComponent = (props) => {
  let bgClass = "alert alert-";
  let iconClass = "bi bi-";
  return (
    <>
      <p className={(bgClass += props.bgColor ? props.bgColor : "danger")}>
        <i
          className={
            (iconClass += props.icon ? props.icon : "exclamation-triangle-fill")
          }
        ></i>
        {props.label ? props.label : "Un problème est survenu"}
      </p>
    </>
  );
};

export default AlertBootstrapComponent;
