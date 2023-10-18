
const Modal = (props) => {
  const handleBackgroundClick = () => {
    props.onClose();
  };

  return (
    <div>
      <div >
        <button onClick={handleBackgroundClick}>
          X
        </button>
        {props.children}
      </div>
    </div>
  );
};

export default Modal;
