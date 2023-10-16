import { useSelector } from "react-redux";
import ProductItem from "./ProductItem";

const ProductList = () => {
  const products = useSelector((state) => state.product.products);

  return (
    <>
      <table>
        <thead>
          <tr>
            <th>Nom</th>
            <th>Prix</th>
            <th>Actions</th>
          </tr>
        </thead>
        <tbody>
          {products.map((product, key) => (
            <tr key={key}>
              <ProductItem key={product.id} product={product} />
            </tr>
          ))}
        </tbody>
      </table>
    </>
  );
};

export default ProductList;
