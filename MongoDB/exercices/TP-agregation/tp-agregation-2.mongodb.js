use("tp_agregation");

// db.restaurants.aggregate([{ $limit: 10 }]);

/* db.restaurants.aggregate([
  { $limit: 10 },
  {
    $sort: {
      name: 1,
    },
  },
]); */

/* db.restaurants.aggregate([
  { $match: { borough: "Brooklyn" } },
  { $limit: 10 },
  {
    $sort: {
      name: 1,
    },
  },
]); */

/* db.restaurants.aggregate([
  { $limit: 10 },
  {
    $project: {
      name: 1,
      borough: 1,
    },
  },
]); */

/* db.restaurants.aggregate([
  { $limit: 10 },
  {
    $project: {
      adress: 0,
      grade: 0,
    },
  },
]); */

/* db.restaurants.aggregate([
  { $limit: 10 },
  {
    $unwind: "$grades",
  },
  {
    $group: {
      _id: "$_id",
      nb_grades: { $sum: 1 },
    },
  },
]); */

/* db.restaurants.aggregate([
  { $limit: 10 },
  {
    $unwind: "$grades",
  },
  {
    $group: {
      _id: "$_id",
      nb_grades: { $sum: 1 },
    },
  },
  {
    $sort: {
      nb_grades: 1,
    },
  },
]); */

/* db.restaurants.aggregate([
  { $limit: 10 },
  {
    $project: {
      uppercase_name: { $toUpper: "$name" },
      borough: 1,
    },
  },
]); */

/* db.restaurants.aggregate([
  { $limit: 10 },
  {
    $project: {
      uppercase_name: { $toUpper: "$name" },
      borough_three_letters: { $substr: ["$borough", 0, 3] },
    },
  },
]); */

/* db.restaurants.aggregate([
  {
    $group: {
      _id: null,
      total_restau: { $sum: 1 },
    },
  },
]); */

db.restaurants.aggregate([
  {
    $group: {
      _id: "$borough",
      count: {
        $sum: 1,
      },
    },
  },
]);
