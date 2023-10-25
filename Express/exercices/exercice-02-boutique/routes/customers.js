import express from "express";
import Customer from "../models/Customer.js";
import { customerDao } from "../app.js";

const customers = express.Router();
customers.use(express.json());

customers.post("/", (req, res) => {
  const { lastname, firstname, phonenumber } = req.body;
  let customer = new Customer(null, lastname, firstname, phonenumber);
  res.json(customerDao.save(customer));
});

customers.get("/", (req, res) => {
  res.json(customerDao.getAll());
});

customers.get("/:id", (req, res) => {
  let customer = customerDao.findById(req.params.id);
  if (customer == undefined) {
    res
      .status(404)
      .json({ code: 404, message: "Aucun client trouvé à cet id" });
  }
  res.json(customer);
});

export default customers;
