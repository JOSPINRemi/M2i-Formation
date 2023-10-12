import { useState, useEffect } from "react";
import { Link, useNavigate } from "react-router-dom";
import axios from "axios";

const Home = () => {
  const [products, setProducts] = useState([]);
  const navigate = useNavigate();

  useEffect(() => {
    axios.get("http://localhost:5000/products").then((response) => {
      setProducts((prevState) => [...response.data]);
    });
  }, []);

  const addProduct = () => {
    navigate("/add");
  };

  return (
    <main>
      <h2>Home Page</h2>
      {products.map((product) => (
        <div key={product.id}>
          <img src={product.img} alt={product.name} />
          <h3>{product.name}</h3>
          <p>
            {product.price.toLocaleString("fr-FR", {
              style: "currency",
              currency: "EUR",
            })}
          </p>
          <Link to={`/product/${product.id}`}>see more</Link>
        </div>
      ))}

      <button onClick={addProduct}>Add Product</button>
    </main>
  );
};

export default Home;
