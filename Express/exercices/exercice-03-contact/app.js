import express from "express";
import ContactDao from "./dao/ContactDao.js";
import Contact from "./models/Contact.js";
import { authMiddleware, dateMiddleware } from "./middlewares/middlewares.js";

const port = 3000;
const app = express();
app.use(express.json());
app.use(cors());
app.use(authMiddleware);
app.use(dateMiddleware);

const contactDao = new ContactDao();

app.post("/", authMiddleware, (req, res) => {
  console.log(re.dataRequest);
  const { lastname, firstname, phonenumber, email } = req.body;
  let contact = new Contact(null, lastname, firstname, phonenumber, email);
  res.status(201).json(contactDao.save(contact));
});

app.get("/", (req, res) => {
  console.log(re.dataRequest);
  res.json(contactDao.getAll());
});

app.get("/:id", (req, res) => {
  console.log(re.dataRequest);
  let contact = contactDao.findById(req.params.id);
  if (contact == undefined) {
    res
      .status(404)
      .json({ code: 404, message: "Aucun contact trouvé à cet id" });
  }
  res.json(contact);
});

app.put("/:id", authMiddleware, (req, res) => {
  console.log(re.dataRequest);
  const { lastname, firstname, phonenumber, email } = req.body;
  let contact = new Contact(
    req.params.id,
    lastname,
    firstname,
    phonenumber,
    email
  );
  contactDao.update(contact)
    ? res
        .status(200)
        .json({ code: 200, message: "Le contact a été mis à jour avec succès" })
    : res.status(400).json({
        code: 400,
        message: "Problème lors de la mise à jour du contact",
      });
});

app.delete("/:id", authMiddleware, (req, res) => {
  console.log(re.dataRequest);
  contactDao.delete(req.params.id);
  res
    .status(200)
    .json({ code: 200, message: "Le contact a été supprimé avec succès" });
});

app.listen(port, () => {
  contactDao.readFile();
  console.log(`http://127.0.0.1:${port}`);
});
