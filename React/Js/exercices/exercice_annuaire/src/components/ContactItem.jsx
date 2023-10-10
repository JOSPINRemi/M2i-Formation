import { useNavigate } from "react-router-dom";

const ContactItem = (props) => {
  const { userInfos } = props;
  const { user, id } = userInfos;

  const navigate = useNavigate();

  const editHandler = () => {
    navigate("/contact/edit/" + id + "?mode=edit");
  };

  const deleteHandler = () => {
    navigate("/contact/delete/" + id + "?mode=delete");
  };

  return (
    <>
      <div>
        <h3>
          {user._lastname.toUpperCase()}{" "}
          {user._firstname.charAt(0).toUpperCase()}
          {user._firstname.slice(1).toLowerCase()}
        </h3>
        <button onClick={editHandler}>Edit</button>
        <button onClick={deleteHandler}>Delete</button>
        <hr />
        <ul>
          <li>
            <b>Email</b> : {user._email}
          </li>
          <li>
            <b>Numéro de téléphone</b> : {user._phonenumber}
          </li>
        </ul>
      </div>
    </>
  );
};

export default ContactItem;
