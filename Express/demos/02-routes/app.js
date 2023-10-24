import express from "express";

const app = express();

app.use(express.json());

app.get("/", (req, res) => {
  res.end("<h1>Bienvenue sur mon API!</h1>");
});

app.post("/users", (req, res) => {
  console.log(req.body);
  res.json(req.data);
});

app.get("/users/:userId", (req, res) => {
  res.json({ userId: req.params.userId, firstname: "toto" });
});

app.get("/z", (req, res) => {
  res.end("Tu es le vrai Z");
});

app.get(/z/, (req, res) => {
  res.end("Bienvenue sur le Z");
});

app.get("/secret", (req, res) => {
  res.json({ secret: "C'est un secret" });
});

app.listen("3000", () => {
  console.log("http://127.0.0.1:3000");
});
