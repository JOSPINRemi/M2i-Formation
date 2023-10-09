import { NavLink, Outlet } from "react-router-dom";

const NavBar = () => {
  return (
    <>
      <header>
        <NavLink to="/">Accueil</NavLink>{" "}
        <NavLink to="/projects">Projets</NavLink>{" "}
        <NavLink to="/contact-me">Contactez-moi</NavLink>{" "}
        <NavLink to="/about">A propos</NavLink>
      </header>
      <Outlet />
      <footer>Ce site a été créé par Rémi JOSPIN</footer>
    </>
  );
};

export default NavBar;
