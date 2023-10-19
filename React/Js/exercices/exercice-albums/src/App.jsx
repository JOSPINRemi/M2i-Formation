import { useEffect } from "react";
import { useDispatch, useSelector } from "react-redux";
import "./App.css";
import AlbumsGridDisplay from "./components/albums/AlbumsGridDisplay";
import { fetchAlbums, setFormMode } from "./components/albums/albumItemsSlice";
import SignForm from "./components/auth/SignForm";
import { setAuthMode } from "./components/auth/authSlice";
import Modal from "./components/shared/Modal";
import NavBar from "./components/shared/NavBar";
import AddAlbumForm from "./components/albums/AddAlbumForm";
import EditAlbumForm from "./components/albums/EditAlbumForm";
import DeleteAlbumForm from "./components/albums/DeleteAlbumForm";

function App() {
  const dispatch = useDispatch();
  const albums = useSelector((state) => state.albums.albums);
  const user = useSelector((state) => state.auth.user);
  const authMode = useSelector((state) => state.auth.authMode);
  const formMode = useSelector((state) => state.albums.formMode);

  useEffect(() => {
    dispatch(fetchAlbums());
  }, []);

  // console.log(albums);

  return (
    <>
      {authMode && (
        <Modal onClose={() => dispatch(setAuthMode(""))}>
          <SignForm />
        </Modal>
      )}
      {user && formMode === "add" && (
        <Modal onClose={() => dispatch(setFormMode(""))}>
          <AddAlbumForm />
        </Modal>
      )}
      {user && formMode === "edit" && (
        <Modal onClose={() => dispatch(setFormMode(""))}>
          <EditAlbumForm />
        </Modal>
      )}
      {user && formMode === "delete" && (
        <Modal onClose={() => dispatch(setFormMode(""))}>
          <DeleteAlbumForm />
        </Modal>
      )}
      <header>
        <NavBar />
      </header>
      <AlbumsGridDisplay albums={albums} />
    </>
  );
}

export default App;
