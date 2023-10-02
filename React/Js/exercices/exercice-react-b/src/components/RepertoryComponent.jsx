const RepertoryComponent = (props) => {
  return (
    <>
      {props.repertory.length === 0 ? (
        <p>Il n'y a personne dans la base données</p>
      ) : (
        <table>
          <thead>
            <tr>
              <th>ID</th>
              <th>Nom</th>
              <th>Prénom</th>
            </tr>
          </thead>
          <tbody>
            {props.repertory.map((person, id) => (
              <tr key={id}>
                <td>{id}</td>
                <td>{person.lastName}</td>
                <td>{person.firstName}</td>
              </tr>
            ))}
          </tbody>
        </table>
      )}
    </>
  );
};

export default RepertoryComponent;
