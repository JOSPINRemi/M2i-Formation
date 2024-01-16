use("tp3");

// db.publications.find({ type: { $regex: "book", $options: "i" } });

// db.publications.find({
//   year: { $gte: 2011 },
// });

// db.publications.find({
//   $and: [{ type: { $regex: "book", $options: "i" } }, { year: { $gte: 2014 } }],
// });

// db.publications.find({ authors: "Toru Ishida" });

// db.publications.distinct("publisher");

db.publications.distinct("authors");
