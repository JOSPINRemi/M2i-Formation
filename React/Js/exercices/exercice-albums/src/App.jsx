import { useDispatch } from "react-redux";
import "./App.css";
import NavBar from "./components/shared/NavBar";
import { useEffect } from "react";
import { fetchAlbums } from "./components/albums/albumItemsSlice";

function App() {
  const dispatch = useDispatch();

  useEffect(() => {
    dispatch(fetchAlbums());
  }, []);

  return (
    <>
      {/* <header>
        <NavBar />
      </header> */}
    </>
  );
}

export default App;
