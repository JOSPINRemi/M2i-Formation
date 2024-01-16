use("demo");
//db.products.insertOne({ name: "Samsung", price: 1000 });
//db.products.find();
//db.createCollection("notes");
// db.notes.insertOne({
//   matiere: "Java",
//   date: new Date(2015 / 5 / 21),
//   note: 15,
// });
//db.notes.find();
// db.products.find();

//Crud
//Insertion ou création :
// db.products.insertOne({ nom: "Table", dimension: 15, poids: 500, prix: 50 });
// db.products.insertMany([
//   { nom: "Table-basse", dimension: 15, poids: 500, prix: 50 },
//   { nom: "Chaise", dimension: 45, poids: 400, prix: 150 },
//   {
//     nom: "Armoire",
//     hauteur: 200,
//     couleurs: ["bleu", "rouge", "noire"],
//     prix: 250,
//   },
// ]);
// db.products.find();
// db.products.insertOne({
//   nom: "Voiture",
//   marque: "Renault",
//   conducteurs: [
//     { user: "Alice", age: 15 },
//     { user: "Nassim", age: 15 },
//   ],
// });

// db.products.insertOne({ _id: 2500, name: "Avion", carburant: "essence" });
db.products.find();
