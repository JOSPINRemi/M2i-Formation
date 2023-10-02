import DemoTableRow from "./components/DemoTableRow";
import FirstComponent from "./components/FirstComponent";
import DemoListingComponent from "./components/DemoListingComponent";

function App() {
  return (
    <div className="App">
      <FirstComponent />
      <table>
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
      </table>
      <DemoListingComponent />
    </div>
  );
}

export default App;
