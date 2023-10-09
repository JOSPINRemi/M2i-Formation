import { NavLink, Outlet } from "react-router-dom";

const Menu = () => {
  return (
    <div>
      <header>
        <h1>Mon menu</h1>
        <NavLink to="/">Home</NavLink>
        <p>Suite</p>
        <NavLink to="/form">Formulaire</NavLink>
      </header>
      <Outlet />
      <footer>Mon pied de page</footer>
    </div>
  );
};

export default Menu;
