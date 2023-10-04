const DisplayComponent = (props) => {
  const { users } = props;

  const displayUsers = (p) => {
    return p.map((user, id) => (
      <tr key={id}>
        <td>{user.firstname}</td>
        <td>{user.lastname}</td>
        <td>{user.birthdate}</td>
      </tr>
    ));
  };

  return (
    <table>
      <thead>
        <tr>
          <th>Nom</th>
          <th>Pénom</th>
          <th>Date de naissance</th>
        </tr>
      </thead>
      {/* <tbody>
        {users.map((user, id) => (
          <tr key={id}>
            <td>{user.firstname}</td>
            <td>{user.lastname}</td>
            <td>{user.birthdate}</td>
          </tr>
        ))}
      </tbody> */}
      <tbody>{displayUsers(users)}</tbody>
    </table>
  );
};

export default DisplayComponent;
