use("demoRelation");

// One To One

/* db.user.insertOne({
  _id: "123",
  nom: "Michel",
  email: "michel@gmail.com",
  profil: { age: 30, hobbies: ["Peinture", "Sport"] },
}); */
// db.user.find();

/* db.user.insertOne({
  _id: "124",
  nom: "Paul",
  email: "paul@gmail.com",
  profil_id: ObjectId("65a7dd9ceb000f0fb0b728de"),
}); */

/* db.profil.insertOne({
  age: 55,
  hobbies: ["Echec", "Football"],
}); */
// db.profil.find();
// db.user.find();

/* db.profil.aggregate([
  {
    $lookup: {
      from: "user",
      localField: "_id",
      foreignField: "profil_id",
      as: "user",
    },
  },
  {$match: {
    _id: ObjectId('65a7dd9ceb000f0fb0b728de')
  }}
]); */

/* db.user.aggregate([
  {
    $lookup: {
      from: "profil",
      localField: "profil_id",
      foreignField: "_id",
      as: "profil",
    },
  },
  {
    $match: {
      _id: { _id: "124" },
    },
  },
  {
    $project: {
      profil_id: 0,
      "profil._id": 0,
    },
  },
]); */

// db.utilisateur.insertOne({ name: "Jean", age: 40 });
/* db.adresse.insertOne({
  street: "rue des fleurs",
  number: 46,
  city: "Croix",
  utilisateur_id: ObjectId("65a7e448b15d65db0c21f9d1"),
}); */
// db.utilisateur.find();
// db.adresse.find();

/* db.utilisateur.aggregate({
  $lookup: {
    from: "adresse",
    localField: "_id",
    foreignField: "utilisateur_id",
    as: "adresse",
  },
}); */

/* db.utilisateur.aggregate([
  {
    $lookup: {
      from: "adresse",
      localField: "_id",
      foreignField: "utilisateur_id",
      as: "adresse",
    },
  },
  {
    $project: { "adresse._id": 0, "adresse.utilisateur_id": 0 },
  },
]); */

// One To Many
/* db.books.insertMany([
  { name: "J'aime bien le distanciel" },
  { name: "Mais je préfère le présentiel" },
]); */

/* db.authors.insertOne({
  name: "Maximus",
  books: [
    ObjectId("65a7ef24dd2a7dd1a668b31a"),
    ObjectId("65a7ef24dd2a7dd1a668b31b"),
  ],
}); */

db.authors.aggregate([
  {
    $lookup: {
      from: "books",
      localField: "books",
      foreignField: "_id",
      as: "books",
    },
  },
  { $project: { "books._id": 0 } },
]);
