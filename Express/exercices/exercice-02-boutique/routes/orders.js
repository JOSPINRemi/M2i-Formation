import express from "express";

const orders = express.Router();

orders.post("/", (req, res) => {
  res.send("Création d'une comande");
});

export default orders;
