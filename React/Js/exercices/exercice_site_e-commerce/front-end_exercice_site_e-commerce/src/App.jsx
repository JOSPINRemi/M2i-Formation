import { NavLink, Outlet, useNavigate } from "react-router-dom";
import "./App.css";

function App() {
  const navigate = useNavigate();

  const loginHandler = () => {
    navigate("/login");
  };

  return (
    <>
      <header>
        <nav>
          <NavLink to="/">Home</NavLink> <NavLink to="/cart">Cart</NavLink>{" "}
          <button type="button" onClick={loginHandler}>
            {localStorage.getItem("isLoggedIn") ? "Logout" : "Login"}
          </button>
        </nav>
      </header>
      <Outlet />
    </>
  );
}

export default App;
