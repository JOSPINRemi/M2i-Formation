use("tp2");

// db.users.insertOne({
//   name: "Chuck Norris",
//   age: 77,
//   hobbies: ["Karate", "Kung-fu", "Ruling the world"],
// });

// db.users.find({ name: "Chuck Norris" });

// db.users.find({ name: "Chuck Norris" }, { _id: 0 });

// db.users.find({ $and: [{ age: { $gte: 20 } }, { age: { $lte: 25 } }] });

// db.users.find({
//   $and: [{ gender: "male" }, { age: { $gte: 30 } }, { age: { $lte: 40 } }],
// });

// db.users.find({ "address.state": "Louisiana" });

// db.users.find().sort({ age: -1 }).limit(20);

// db.users.find({ $and: [{ gender: "female" }, { age: 30 }] }).count();

// db.users.updateMany({}, { $unset: { phone: 1 } });

// db.users.updateOne(
//   { name: "Chuck Norris" },
//   {
//     $set: {
//       age: "infinity",
//     },
//   }
// );

// db.users.updateMany({ age: { $gt: 50 } }, { $push: { hobbies: "jardinage" } });
