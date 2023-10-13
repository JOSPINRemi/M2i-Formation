import axios from "axios";
import { useRef } from "react";
import Product from "../models/Product.js";

const AddProduct = () => {
  const formRef = useRef();

  const nameRef = useRef();
  const imgRef = useRef();
  const descriptionRef = useRef();
  const priceRef = useRef();

  const formHandler = (e) => {
    e.preventDefault();
    axios
      .post(
        "http://localhost:5000/products",
        new Product(
          nameRef.current.value,
          imgRef.current.value,
          descriptionRef.current.value,
          +priceRef.current.value
        )
      )
      .then((response) => {
        console.log(
          `The product ${response.data.name} has been added to the store`
        );
        formRef.current.reset();
      });
  };

  return (
    <>
      <h2>Add Product</h2>
      <form onSubmit={formHandler} ref={formRef}>
        <div>
          <label htmlFor="name">Name : </label>
          <input type="text" name="name" id="name" ref={nameRef} required />
        </div>
        <div>
          <label htmlFor="img">Image URL : </label>
          <input type="text" name="img" id="img" ref={imgRef} required />
        </div>
        <div>
          <label htmlFor="description">Description : </label>
          <textarea
            name="description"
            id="description"
            cols="30"
            rows="10"
            ref={descriptionRef}
            required
          ></textarea>
        </div>
        <div>
          <label htmlFor="price">Price : </label>
          <input
            type="number"
            name="price"
            id="price"
            ref={priceRef}
            required
          />
        </div>
        <button type="submit">Add Product</button>
      </form>
    </>
  );
};

export default AddProduct;
