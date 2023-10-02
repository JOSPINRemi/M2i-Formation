import mesStyles from "./BoutonComponent.module.css";

const BoutonComponent = (ceQueJeVeuxRecup) => {
  let textBouton = ceQueJeVeuxRecup.textBouton ?? "titi"; // Nullish coalescing operator

  return (
    <>
      <button style={{ backgroundColor: ceQueJeVeuxRecup.couleurBouton }}>
        {textBouton}
      </button>
      <p className={mesStyles.paragrapheJaune}>Test</p>
    </>
  );
};

export default BoutonComponent;
