use("hopital");

// db.patient.insertMany([
//   {
//     firstName: "Bartholomew Henry",
//     lastName: "Allen",
//     age: 30,
//     history: [{ desease: "rhume", treatment: "sirop" }],
//   },
//   {
//     firstName: "Peter Jason",
//     lastName: "Quill",
//     age: 30,
//     history: [{ desease: "grippe", treatment: "anti-biotique" }],
//   },
//   {
//     firstName: "Nastu",
//     lastName: "Dragnir",
//     age: 300,
//     history: [{ desease: "inflammation intestinale", treatment: "anti-inflammatoire" }],
//   },
// ]);

// db.patient.updateOne(
//   { _id: ObjectId("65a66a38a30f0cf4d080f889") },
//   {
//     $set: {
//       firstName: "Natsu",
//       lastName: "Dragneel",
//       age: 400,
//       history: [
//         {
//           desease: "inflammation de la gorge",
//           treatment: "anti-inflammatoire",
//         },
//       ],
//     },
//   }
// );

// db.patient.find({ age: { $gt: 29 } });

db.patient.deleteMany({ "history.desease": "rhume" });
