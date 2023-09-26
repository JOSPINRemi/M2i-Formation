import { User } from "./Interface/User.js";
import { Admin } from "./Interface/Admin.js";

type Personne = User | Admin;

let tab: Personne[] = [];
let user: User = {
  nom: "Toto Dupont",
  age: 35,
  occupation: "Facteur",
};
tab.push(user);

let admin: Admin = {
  nom: "Jeanne Doe",
  age: 25,
  role: "Admin",
};
tab.push(admin);

user = { nom: "Michel Michel", age: 23, occupation: "Lutteur" };
tab.push(user);

admin = { nom: "Michael Flinch", age: 64, role: "Gérant" };
tab.push(admin);

tab.forEach((personne) => {
  console.log(`Nom : ${personne.nom} et age : ${personne.age}`);
});
