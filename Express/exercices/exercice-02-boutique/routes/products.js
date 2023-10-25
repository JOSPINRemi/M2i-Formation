import express from "express";
import Product from "../models/Product.js";
import { productDao } from "../app.js";

const products = express.Router();
products.use(express.json());

products.post("/", (req, res) => {
  const { title, price, quantity } = req.body;
  let product = new Product(null, title, price, quantity);
  res.json(productDao.save(product));
});

products.get("/:id", (req, res) => {
  let product = productDao.findById(req.params.id);
  if (product == undefined) {
    res
      .status(404)
      .json({ code: 404, message: "Aucun produit trouvé à cet id" });
  }
  res.json(product);
});

export default products;
