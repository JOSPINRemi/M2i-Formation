import { useContext, useEffect, useRef } from "react";
import { useParams, useNavigate, useSearchParams } from "react-router-dom";
import { AppContext } from "../contexts/AppContext";
import Contact from "../models/Contact";

const ContactPage = () => {
  const { users, setUsers } = useContext(AppContext);

  const { action, id } = useParams();

  const [searchParams] = useSearchParams();
  const mode = searchParams.get("mode");

  const lastNameRef = useRef();
  const firstNameRef = useRef();
  const emailRef = useRef();
  const phoneNumberRef = useRef();

  const navigate = useNavigate();

  useEffect(() => {
    if (mode) {
      lastNameRef.current.value = users.find(
        (user) => user._id === id
      )._lastname;
      firstNameRef.current.value = users.find(
        (user) => user._id === id
      )._firstname;
      emailRef.current.value = users.find((user) => user._id === id)._email;
      phoneNumberRef.current.value = users.find(
        (user) => user._id === id
      )._phonenumber;
    }
  });

  const submitHandler = (e) => {
    e.preventDefault();

    if (mode) {
      switch (mode) {
        case "edit":
          let settedUser = new Contact(
            lastNameRef.current.value,
            firstNameRef.current.value,
            emailRef.current.value,
            phoneNumberRef.current.value
          );
          setUsers((prevState) =>
            prevState.map((user) => {
              if (user._id == id) {
                return settedUser;
              }
              return user;
            })
          );
          break;
        //   case "delete":
        //     break;
      }
    } else {
      let newUser = new Contact(
        lastNameRef.current.value,
        firstNameRef.current.value,
        emailRef.current.value,
        phoneNumberRef.current.value
      );
      setUsers((prevState) => [...prevState, newUser]);
    }

    navigate("/contacts");
  };

  return (
    <main>
      <h2>{action.charAt(0).toUpperCase() + action.slice(1)} Contact</h2>
      <form onSubmit={submitHandler}>
        <div className="mb-3">
          <label htmlFor="lastname" className="form-label">
            Nom :
          </label>
          <input
            type="text"
            name="lastname"
            id="lastname"
            required
            ref={lastNameRef}
            className="form-control"
            readOnly={mode === "delete"}
          />
        </div>
        <div className="mb-3">
          <label htmlFor="firstname" className="form-label">
            Prénom :
          </label>
          <input
            type="text"
            name="firstname"
            id="firstname"
            required
            ref={firstNameRef}
            className="form-control"
            readOnly={mode === "delete"}
          />
        </div>
        <div className="mb-3">
          <label htmlFor="email" className="form-label">
            Email :
          </label>
          <input
            type="email"
            name="email"
            id="email"
            required
            ref={emailRef}
            className="form-control"
            readOnly={mode === "delete"}
          />
        </div>
        <div className="mb-3">
          <label htmlFor="phonenumber" className="form-label">
            Numéro de téléphone :
          </label>
          <input
            type="tel"
            name="phonenumber"
            id="phonenumber"
            required
            ref={phoneNumberRef}
            className="form-control"
            readOnly={mode === "delete"}
          />
        </div>
        <div className="text-end">
          <button className="btn btn-outline-light">
            {action.charAt(0).toUpperCase()}
            {action.slice(1)}
          </button>
        </div>
      </form>
    </main>
  );
};

export default ContactPage;
