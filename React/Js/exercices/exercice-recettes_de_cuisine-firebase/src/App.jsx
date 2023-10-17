import { useSelector } from "react-redux";
import "./App.css";
import NavBar from "./components/navbar/NavBar";
import SignForm from "./components/auth/SignForm";
import RecipesList from "./components/recipes/RecipesList";

function App() {
  const user = useSelector((state) => state.auth.user);

  return (
    <>
      {user ? (
        <>
          <header>
            <NavBar />
          </header>
          <main>
            <RecipesList user={user} />
          </main>
        </>
      ) : (
        <>
          <main>
            <SignForm />
          </main>
        </>
      )}
    </>
  );
}

export default App;
