import express from "express";
import Todo from "./models/Todo.js";

const app = express();

app.use(express.json());

let todos = [];

app.get("/", (req, res) => {
  res.end("<h1>Bienvenue sur l'API pour gerer les todos</h1>");
});

// un EndPoint pour ajouter une todo
app.post("/todos", (req, res) => {
  todos.push(
    new Todo(req.body.id, req.body.title, req.body.content, req.body.status)
  );
  res.json(req.body);
});

//TODO un Endpoint pour modifier une todo
app.put("/todos/:todoId", (req, res) => {
  const findedTodo = todos.find((todo) => (todo.id = req.params.todoId));
  new Todo(req.body.id, req.body.title, req.body.content, req.body.status);
  res.json();
});

// un EndPoint pour récupérer la liste de todos
app.get("/todos", (req, res) => {
  res.json(todos);
});

// un Endpoint pour récupérer une todo
app.get("/todos/:todoId", (req, res) => {
  const findedTodo = todos.find((todo) => (todo.id = req.params.todoId));
  res.json(findedTodo);
});

//TODO un EndPoint pour supprimer une todo
app.delete("/todos/:todoId", (req, res) => {});

//TODO un Endpoint pour rechercher des todos par leur titre
app.get("/todos", (req, res) => {});

//TODO un Endpoint pour modifier le statut d'une todo
app.patch("/todos/:todoId", (req, res) => {
  res.json(req.body);
});

app.listen("3000", () => {
  console.log("http://127.0.0.1:3000");
});
