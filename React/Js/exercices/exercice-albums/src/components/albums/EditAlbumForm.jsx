import { useEffect, useRef } from "react";
import { useDispatch, useSelector } from "react-redux";
import { editAlbum, setFormMode } from "./albumItemsSlice";

const EditAlbumForm = () => {
  const dispatch = useDispatch();
  const titleRef = useRef();
  const releaseDateRef = useRef();
  const artistRef = useRef();
  const scoreRef = useRef();
  const coverURLRef = useRef();

  const selectedAlbum = useSelector((state) => state.albums.selectedAlbum);

  useEffect(() => {
    if (selectedAlbum) {
      titleRef.current.value = selectedAlbum.title;
      releaseDateRef.current.value = selectedAlbum.releaseDate;
      artistRef.current.value = selectedAlbum.artist;
      scoreRef.current.value = selectedAlbum.score;
      coverURLRef.current.value = selectedAlbum.coverURL;
    }
  }, [
    selectedAlbum.title,
    selectedAlbum.releaseDate,
    selectedAlbum.artist,
    selectedAlbum.score,
    selectedAlbum.coverURL,
  ]);

  const submitFormHandler = (event) => {
    event.preventDefault();
    const newAlbum = {
      title: titleRef.current.value,
      releaseDate: releaseDateRef.current.value,
      artist: artistRef.current.value,
      score: +scoreRef.current.value,
      coverURL: coverURLRef.current.value,
    };
    dispatch(editAlbum(newAlbum));
    dispatch(setFormMode(""));
  };

  return (
    <>
      <h2>Editer un titre</h2>
      <form onSubmit={submitFormHandler}>
        <div className="mb-3">
          <label htmlFor="title" className="form-label">
            Titre :
          </label>
          <input
            type="text"
            name="title"
            id="title"
            className="form-control"
            ref={titleRef}
            required
          />
        </div>
        <div className="mb-3">
          <label htmlFor="releaseDate" className="form-label">
            Date de sortie :
          </label>
          <input
            type="date"
            name="releaseDate"
            id="releaseDate"
            className="form-control"
            ref={releaseDateRef}
            required
          />
        </div>
        <div className="mb-3">
          <label htmlFor="artiste" className="form-label">
            Artiste :
          </label>
          <input
            type="text"
            name="artiste"
            id="artiste"
            className="form-control"
            ref={artistRef}
            required
          />
        </div>
        <div className="mb-3">
          <label htmlFor="score" className="form-label">
            Score :
          </label>
          <input
            type="number"
            name="score"
            id="score"
            className="form-control"
            ref={scoreRef}
            required
          />
        </div>
        <div className="mb-3">
          <label htmlFor="coverURL" className="form-label">
            URL de la pochette :
          </label>
          <input
            type="text"
            name="coverURL"
            id="coverURL"
            className="form-control"
            ref={coverURLRef}
            required
          />
        </div>
        <button type="submit">Editer l'album</button>
      </form>
    </>
  );
};

export default EditAlbumForm;
