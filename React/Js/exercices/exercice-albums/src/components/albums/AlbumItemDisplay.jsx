import greyStar from "../../assets/grey_star.jpg";
import yelloStar from "../../assets/yellow_star.jpg";

import { useDispatch, useSelector } from "react-redux";
import { setSelectedAlbum, setFormMode } from "./albumItemsSlice";

const AlbumItemDisplay = (props) => {
  const dispatch = useDispatch();
  const user = useSelector((state) => state.auth.user);
  const formMode = useSelector((state) => state.albums.formMode);

  const { album } = props;

  const displayStars = () => {
    let stars = [];
    for (let i = 0; i < 5; i++) {
      if (i < album.score) {
        stars.push(
          <img
            key={i}
            src={yelloStar}
            alt="etoile_jaune"
            style={{ width: "10%" }}
          />
        );
      } else {
        stars.push(
          <img
            key={i}
            src={greyStar}
            alt="etoile_grise"
            style={{ width: "10%" }}
          />
        );
      }
    }
    return stars;
  };

  const editAlbumHandler = () => {
    console.log("editAlbumHandler");
    dispatch(setSelectedAlbum(album));
    dispatch(setFormMode("edit"));
    console.log("EditMode");
  };

  const deleteAlbumHandler = () => {
    console.log("deleteAlbumHandler");
    dispatch(setSelectedAlbum(album));
    dispatch(setFormMode("delete"));
    console.log("DeleteMode");
  };

  return (
    <>
      <div className="card">
        <div className="card-header text-center">
          <h2>{album.title}</h2>
        </div>
        <img src={album.coverURL} alt={album.title + " cover"} />
        <div className="card-footer">
          <p>
            <b>Artiste:</b> {album.artist}
          </p>
          <hr />
          <p>
            <b>Release date:</b>{" "}
            {new Date(album.releaseDate).toLocaleDateString()}
          </p>
          <hr />
          <p>
            <b>Score:</b> {displayStars()}
          </p>
          {user && formMode === "" && (
            <>
              <button
                type="button"
                className="btn btn-warning"
                onClick={editAlbumHandler}
                // onClick={() => {
                //   alert("Editing mode isn't yet implemented");
                // }}
              >
                Modifier
              </button>
              <button
                type="button"
                className="btn btn-danger"
                onClick={deleteAlbumHandler}
                // onClick={() => {
                //   alert("Deleting mode isn't yet implemented");
                // }}
              >
                Supprimer
              </button>
            </>
          )}
        </div>
      </div>
    </>
  );
};

export default AlbumItemDisplay;
