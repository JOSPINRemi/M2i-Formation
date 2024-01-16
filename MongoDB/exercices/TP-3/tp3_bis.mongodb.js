use("info");

// db.produits.insertMany([
//   {
//     nom: "Macbook Pro",
//     fabricant: "Apple",
//     prix: 11435.99,
//     options: ["Intel Core i5", "Retina Display", "Long life battery"],
//   },
//   {
//     nom: "Macbook Air",
//     fabricant: "Apple",
//     prix: 125794.73,
//     options: ["Intel Core i7", "SSD", "Long life battery"],
//   },
//   {
//     nom: "Thinkpad X230",
//     fabricant: "Lenovo",
//     prix: 114358.74,
//     ultrabook: true,
//     options: ["Intel Core i5", "SSD", "Long life battery"],
//   },
// ]);

// db.produits.find();

db.produits.find({
  _id: db.produits.findOne(
    { nom: { $regex: "thinkpad", $options: "i" } },
    { _id: 1 }
  ),
});
