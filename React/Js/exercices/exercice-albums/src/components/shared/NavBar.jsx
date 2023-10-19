import { useDispatch, useSelector } from "react-redux";
import { removeUser, setAuthMode } from "../auth/authSlice";

import { setFormMode } from "../albums/albumItemsSlice";

const NavBar = () => {
  const user = useSelector((state) => state.auth.user);
  const dispatch = useDispatch();

  return (
    <>
      <nav
        className="navbar navbar-expand-lg bg-body-tertiary"
        data-bs-theme="dark"
      >
        <div className="container-fluid">
          <span className="navbar-brand">
            <i className="bi bi-globe"></i>eAlbums
          </span>
          {user && (
            <button
              onClick={() => dispatch(setFormMode("add"))}
              className="ms-auto me-5 btn btn-success"
            >
              Ajouter un album
            </button>
          )}

          <button
            onClick={() =>
              !user ? dispatch(setAuthMode("Sign in")) : dispatch(removeUser())
            }
            className="me-0 btn btn-info"
          >
            {user ? "Déconnexion" : "Se connecter"}
          </button>
        </div>
      </nav>
    </>
  );
};

export default NavBar;
