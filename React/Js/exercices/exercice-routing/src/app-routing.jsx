import { createBrowserRouter } from "react-router-dom";
import App from "./App";
import NavBar from "./routes/NavBar";
import Projects from "./routes/Projects";
import Contact from "./routes/Contact";
import About from "./routes/About";

const router = createBrowserRouter([
  {
    path: "/",
    element: <NavBar />,
    children: [
      {
        path: "/",
        element: <App />,
      },
      {
        path: "/projects",
        element: <Projects />,
      },
      {
        path: "/contact-me",
        element: <Contact />,
      },
      {
        path: "/about",
        element: <About />,
      },
    ],
  },
]);

export default router;
