import AlbumItemDisplay from "./AlbumItemDisplay";

const AlbumsGridDisplay = (props) => {
  const { albums } = props;
  return (
    <>
      <div className="container">
        <div className="row row-cols-2">
          {albums.map((album) => (
            <div className="col" key={album.id}>
              <AlbumItemDisplay album={album} />
            </div>
          ))}
        </div>
      </div>
    </>
  );
};

export default AlbumsGridDisplay;
