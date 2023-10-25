import express from "express";
import { queryLogger } from "../middlewares/middlewares.js";

const digimons = express.Router();

digimons.use(queryLogger);

digimons.get("/", (req, res) => {
  res.send("Liste des digimons");
});

export default digimons;
