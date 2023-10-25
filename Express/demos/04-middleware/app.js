import express from "express";
import { dateMiddleware } from "./middlewares/middlewares.js";
import auth from "./routes/auth.js";
import digimons from "./routes/digimons.js";

const app = express();

app.use(express.json());
app.use(dateMiddleware);
app.use("/digimons", digimons);
app.use("/auth", auth);

app.get("/", (req, res) => {
  console.log(req.dateRequest);
  res.send("Test du middleware dateMiddleware");
});

app.listen(4000, () => {
  console.log("http://127.0.0.1:4000");
});
