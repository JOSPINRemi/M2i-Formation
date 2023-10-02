const DemoVarInject = () => {
  const monPrenom = "Antoine";
  const maClasse = "text-danger";
  const sonAge = 61;

  return (
    <>
      {/* {sonAge >= 18 ? <p>Je suis vrai</p> : <p>Je suis faux</p>} */
      /*opération ternaire if else*/}
      {
        sonAge >= 18 && (
          <p>Je suis vrai</p>
        ) /*Opération sans else (seulement if then)*/
      }
      <p className={maClasse}>Mon prénom est {monPrenom}</p>
      <p className={sonAge >= 18 ? "text-succes" : "text-danger"}>
        Il est <b>{sonAge >= 18 ? "majeur" : "mineur"}</b>
      </p>
    </>
  );
};

export default DemoVarInject;
