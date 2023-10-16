import { useRef } from "react";
import { useDispatch } from "react-redux";
import { addProduct } from "./ProductSlice";

const AddProduct = () => {
  const nameRef = useRef();
  const priceRef = useRef();
  const formRef = useRef();
  const dispatch = useDispatch();

  const handleSubmit = (event) => {
    event.preventDefault();
    dispatch(
      addProduct({ name: nameRef.current.value, price: priceRef.current.value })
    );
    formRef.current.reset();
  };

  return (
    <>
      <h2>Ajouter un produit</h2>
      <form onSubmit={handleSubmit} ref={formRef}>
        <div>
          <label htmlFor="productname">Nom du produit : </label>
          <input
            type="text"
            name="productname"
            id="productname"
            ref={nameRef}
            placeholder="e.g: laptop"
            required
          />
        </div>
        <div>
          <label htmlFor="price">Prix du produit : </label>
          <input
            type="number"
            step={0.01}
            defaultValue={0}
            name="price"
            id="price"
            ref={priceRef}
          />
        </div>
        <button type="submit">Submit</button>
      </form>
    </>
  );
};

export default AddProduct;
