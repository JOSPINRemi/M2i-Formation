import { NavLink, Outlet, useNavigate } from "react-router-dom";
import "./App.css";
import AddProduct from "./components/AddProduct.jsx";

function App() {
  const navigate = useNavigate();

  const loginHandler = () => {
    if (localStorage.getItem("isLoggedIn") === "true") {
      if (confirm("Do you really want to logout ?")) {
        localStorage.setItem("isLoggedIn", false);
      }
    } else {
      navigate("/login");
    }
  };

  return (
    <>
      <header>
        <nav>
          <NavLink to="/">Home</NavLink> <NavLink to="/cart">Cart</NavLink>{" "}
          <NavLink to="/add">Add Product</NavLink>{" "}
          <button type="button" onClick={loginHandler}>
            {localStorage.getItem("isLoggedIn") === "true" ? "Logout" : "Login"}
          </button>
        </nav>
      </header>
      <Outlet />
    </>
  );
}

export default App;
