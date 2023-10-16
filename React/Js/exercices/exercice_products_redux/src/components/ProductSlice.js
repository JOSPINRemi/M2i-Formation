import { createSlice } from "@reduxjs/toolkit";

const productSlice = createSlice({
  name: "products",
  initialState: {
    products: [],
  },
  reducers: {
    addProduct: (state, action) => {
      const newProduct = {
        id: Date.now(),
        name: action.payload.name,
        price: action.payload.price,
      };
      state.products.push(newProduct);
    },
    deleteProduct: (state, action) => {
      state.products = state.products.filter(
        (product) => product.id !== action.payload
      );
    },
    updateProductDetails: (state, action) => {
      const product = state.products.find(
        (product) => product.id === action.payload.id
      );
      product.name = action.payload.name;
      product.price = action.payload.price;
    },
  },
});

export const { addProduct, deleteProduct, updateProductDetails } =
  productSlice.actions;

export default productSlice.reducer;
