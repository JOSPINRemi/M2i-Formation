import { useState, useEffect } from "react";
import { useParams } from "react-router-dom";
import axios from "axios";

const ProductDetails = () => {
  const { id } = useParams();
  const [product, setProduct] = useState(null);

  useEffect(() => {
    axios.get(`http://localhost:5000/products/${id}`).then((response) => {
      setProduct(response.data);
    });
  }, [id]);

  const addToCart = () => {
    let userCart = [];
    if (localStorage.getItem("cart")) {
      userCart = JSON.parse(localStorage.getItem("cart"));
      userCart.push(product);
      localStorage.setItem("cart", JSON.stringify(userCart));
    } else {
      userCart.push(product);
      localStorage.setItem("cart", JSON.stringify(userCart));
    }
    console.log(`${product.name} added to cart`);
  };

  if (!product) {
    return <p>Chargement ...</p>;
  }

  return (
    <main>
      <h2>Details</h2>
      <h3>{product.name}</h3>
      <img src={product.img} alt={product.name} />
      <p>{product.description}</p>
      <p>
        {product.price.toLocaleString("fr-FR", {
          style: "currency",
          currency: "EUR",
        })}
      </p>
      <button type="button" onClick={addToCart}>
        Add to cart
      </button>
    </main>
  );
};

export default ProductDetails;
