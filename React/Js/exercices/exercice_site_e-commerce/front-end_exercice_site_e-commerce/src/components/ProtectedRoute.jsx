import { Navigate } from "react-router-dom";

const ProtectedRoute = (props) => {
  const isLoggedIn = localStorage.getItem("isLoggedIn");
  if (isLoggedIn) {
    return <>{props.children}</>;
  } else {
    return <Navigate to={"/login"} />;
  }
};

export default ProtectedRoute;
