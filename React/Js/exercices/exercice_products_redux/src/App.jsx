import "./App.css";
import AddProduct from "./components/AddProduct";

import ProductList from "./components/ProductList";

function App() {
  return (
    <>
      <h1>Application de gestion de produits</h1>
      <ProductList />
      <AddProduct />
    </>
  );
}

export default App;
