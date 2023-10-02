import RepertoryComponent from "./components/RepertoryComponent";

const tabPersons = [];
const tabPersons2 = [];
tabPersons2.push({ lastName: "DOE", firstName: "John" });
tabPersons2.push({ lastName: "SMITH", firstName: "Matt" });

function App() {
  return (
    <div className="App">
      <RepertoryComponent repertory={tabPersons} />
      <RepertoryComponent repertory={tabPersons2} />
    </div>
  );
}

export default App;
