import alertIcon from "../assets/images/warning.png";

const AlertComponent = (props) => {
  return (
    <div
      style={{
        backgroundColor: props.bgColor ? props.bgColor : "red",
        display: "flex",
      }}
    >
      <img
        src={props.icon ? props.icon : alertIcon}
        alt="Alert"
        style={{ width: "5%" }}
      />
      <p>{props.label ? props.label : "Un problème est survenu"}</p>
    </div>
  );
};

export default AlertComponent;
