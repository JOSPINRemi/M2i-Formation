import AlertComponent from "./components/AlertComponent";
import AlertBootstrapComponent from "./components/AlertBootstrapComponent";

function App() {
  return (
    <div className="App">
      {/* <AlertComponent />
      <AlertComponent bgColor="green" label="Tout est ok" icon="warning.png" /> */}

      <AlertBootstrapComponent />
      <AlertBootstrapComponent
        bgColor="success"
        label="Tout est ok"
        icon="hand-thumbs-up-fill"
      />
    </div>
  );
}

export default App;
