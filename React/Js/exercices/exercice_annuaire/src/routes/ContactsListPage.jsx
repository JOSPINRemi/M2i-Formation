import { useContext } from "react";
import { useNavigate } from "react-router-dom";
import { AppContext } from "../contexts/AppContext";
import ContactItem from "../components/ContactItem";

const ContactsListPage = () => {
  const { users } = useContext(AppContext);

  const navigate = useNavigate();

  const clickHandler = () => {
    navigate("/contact/add");
  };

  return (
    <main>
      <h2>Contacts List</h2>
      <button
        type="button"
        onClick={clickHandler}
        className="btn btn-outline-light"
      >
        Add
      </button>
      <hr />
      {users.length <= 0 ? (
        <p>La liste de contacts est vide</p>
      ) : (
        users.map((user) => (
          <ContactItem
            key={user._id}
            userInfos={{ user: user, id: user._id }}
          />
        ))
      )}
    </main>
  );
};

export default ContactsListPage;
