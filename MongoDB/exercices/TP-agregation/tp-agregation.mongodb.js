use("tp_agregation");

/* db.publications.aggregate([
  { $match: { authors: "Toru Ishida" } },
  { $sort: { title: 1, "pages.start": 1 } },
]); */

/* db.publications.aggregate([
  { $match: { authors: "Toru Ishida" } },
  { $sort: { title: 1, "pages.start": 1 } },
  { $project: { title: 1, pages: 1 } },
]); */

/* db.publications.aggregate([
  { $match: { authors: "Toru Ishida" } },
  { $count: "nbre_publications" },
]); */

/* db.publications.aggregate([
  {
    $match: {
      year: { $gte: 2011 },
    },
  },
  {
    $group: {
      _id: "$type",
      nbre_publications: { $sum: 1 },
    },
  },
]); */

db.publications.aggregate([
  { $unwind: "$authors" },
  {
    $group: {
      _id: "$authors",
      nbre_publications: { $sum: 1 },
    },
  },
  {
    $sort: {
      nbre_publications: -1,
    },
  },
]);
