import { useDispatch } from "react-redux";
import { deleteProduct, updateProductDetails } from "./ProductSlice";
import { useRef, useState } from "react";

const ProductItem = (props) => {
  const product = props.product;

  const dispatch = useDispatch();

  const [editMode, setEditMode] = useState(false);
  const nameRef = useRef();
  const priceRef = useRef();

  const handleChange = () => {
    setEditMode(!editMode);
    if (editMode) {
      dispatch(
        updateProductDetails({
          id: product.id,
          name: nameRef.current?.value,
          price: priceRef.current?.value,
        })
      );
    }
  };

  return (
    <>
      <td>
        {editMode ? (
          <input type="text" defaultValue={product.name} ref={nameRef} />
        ) : (
          <p>{product.name}</p>
        )}
      </td>
      <td>
        {editMode ? (
          <input
            type="number"
            step={0.01}
            defaultValue={product.price}
            ref={priceRef}
          />
        ) : (
          <p style={{ display: "inline" }}>{product.price}</p>
        )}
        <span>&euro;</span>
      </td>
      <td>
        <button type="button" onClick={handleChange}>
          {editMode ? "Confirmer" : "Modifier le produit"}
        </button>
        <button
          type="button"
          onClick={
            editMode
              ? () => setEditMode(!editMode)
              : () => dispatch(deleteProduct(product.id))
          }
        >
          {editMode ? "Annuler" : "Supprimer"}
        </button>
      </td>
    </>
  );
};

export default ProductItem;
