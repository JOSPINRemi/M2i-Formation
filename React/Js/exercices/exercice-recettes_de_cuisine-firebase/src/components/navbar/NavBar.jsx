import { useSelector } from "react-redux";

const NavBar = () => {
  const user = useSelector((state) => state.auth.user);

  return (
    <>
      <nav className="navbar bg-dark">
        <div className="container-fluid">
          <a className="navbar-brand text-white" href="#">
            eRecipes
          </a>
          <button className="btn btn-secondary" type="button">
            {user ? "Se déconnecter" : "Se connecter"}
          </button>
        </div>
      </nav>
    </>
  );
};

export default NavBar;
