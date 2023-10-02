const DemoListingComponent = () => {
  const mesPrenoms = ["John", "Albert", "Chloé", "Tao", "Ihab", "Julie"];

  const monPrenom = "Albert";

  return (
    <>
      <h1>DemoListingComponent</h1>
      <hr />
      <ul>
        {mesPrenoms.map((prenom, i) => (
          <li key={i}>{prenom}</li>
        ))}
      </ul>
    </>
  );
};

export default DemoListingComponent;
