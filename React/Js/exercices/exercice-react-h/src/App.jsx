import LoginComponent from "./components/LoginComponent";

function App() {
  const displayFormInfos = (args) => {
    args.map((argument) => {
      console.log(argument);
    });
  };

  return (
    <>
      <LoginComponent displayInfos={displayFormInfos} />
    </>
  );
}

export default App;
