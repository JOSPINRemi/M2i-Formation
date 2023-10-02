import DemoTableRow from "./components/DemoTableRow";
import FirstComponent from "./components/FirstComponent";
import DemoListingComponent from "./components/DemoListingComponent";
import DemoVarInject from "./components/DemoVarInject";
import BoutonComponent from "./components/BoutonComponent";

function App() {
  function randomColor() {
    if (Math.random >= 0.5) {
      return "red";
    } else {
      return "grey";
    }
  }

  return (
    <div className="App">
      {/* <FirstComponent /> */}
      {/* <table>
        <thead>
          <tr>
            <th>ColA</th>
            <th>ColB</th>
            <th>ColC</th>
          </tr>
        </thead>
        <tbody>
          <tr>
            <DemoTableRow />
          </tr>
          <tr>
            <DemoTableRow />
          </tr>
          <tr>
            <DemoTableRow />
          </tr>
        </tbody>
      </table> */}
      {/* <DemoListingComponent /> */}
      {/* <DemoVarInject /> */}
      <BoutonComponent textBouton="Bonjour" />
      <br />
      <BoutonComponent textBouton="Au revoir" />
      <br />
      <BoutonComponent couleurBouton="blue" />
      <br />
      <BoutonComponent couleurBouton="green" />
      <br />
      <BoutonComponent couleurBouton={randomColor()} />
      <br />
      <img src="" alt="" />
    </div>
  );
}

export default App;
