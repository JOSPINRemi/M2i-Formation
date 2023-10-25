import express from "express";
import { authMiddleware } from "../middlewares/middlewares.js";

const auth = express.Router();

auth.post("/admin", authMiddleware, (req, res) => {
  res.send("Mes infos hyper secrètes");
});

auth.get("/", (req, res) => {
  res.send("Bienvenue sur le routeur d'authentification");
});

export default auth;
