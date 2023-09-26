let tab = [];
let user = {
    nom: "Toto Dupont",
    age: 35,
    occupation: "Facteur",
};
tab.push(user);
let admin = {
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
export {};
