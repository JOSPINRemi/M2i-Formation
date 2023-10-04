const ChildComponent = (props) => {
  const { maProp, maPropB, maFonction, setMaState } = props;

  const sayHello = () => {
    console.log("Hello world form ChildComponent");
    maFonction();
  };

  return (
    <>
      <h1>Child Compoeent</h1>
      <hr />
      <button onClick={sayHello}>Click me!</button>
      <input type="text" onInput={(e) => setMaState(e.target.value)} />
      <p>maProp : {maProp}</p>
      <p>maPropB : {maPropB}</p>
    </>
  );
};

export default ChildComponent;
