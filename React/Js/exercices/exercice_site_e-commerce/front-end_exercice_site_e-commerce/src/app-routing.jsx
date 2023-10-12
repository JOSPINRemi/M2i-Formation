import { createBrowserRouter } from "react-router-dom";

import App from "./App";
import ErrorPage from "./routes/ErrorPage";
import Home from "./routes/Home";
import ProductDetails from "./routes/ProductDetails";
import Cart from "./routes/Cart";
import ProtectedRoute from "./components/ProtectedRoute";
import AddProduct from "./components/AddProduct";
import Login from "./components/Login";

const router = createBrowserRouter([
  {
    path: "/",
    element: <App />,
    errorElement: <ErrorPage />,
    children: [
      { path: "/", element: <Home /> },
      { path: "/product/:id", element: <ProductDetails /> },
      {
        path: "/add",
        element: (
          <ProtectedRoute>
            <AddProduct />
          </ProtectedRoute>
        ),
      },
      { path: "/cart", element: <Cart /> },
      { path: "/login", element: <Login /> },
    ],
  },
]);

export default router;
