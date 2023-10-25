import express from "express";

const dogs = express.Router();

dogs.get("/", (req, res) => {
  res.send("Liste de chiens");
});

export default dogs;
