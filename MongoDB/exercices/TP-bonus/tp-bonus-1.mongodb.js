use("tp-bonus-1");

// db.sportifs.find();
// Question 1 :
/* db.sportifs.aggregate([
  {
    $match: {
      $and: [{ Age: { $gte: 20 } }, { Age: { $lte: 30 } }],
    },
  },
  {
    $project: {
      IdSportif: 1,
      Nom: 1,
      Prenom: 1,
    },
  },
]); */

// db.gymnases.find();

// Question 2 :
/* db.gymnases.aggregate({
  $match: {
    $and: [
      {
        $or: [
          {
            Ville: {
              $regex: "Villetaneuse",
              $options: "i",
            },
          },
          {
            Ville: {
              $regex: "Sarcelles",
              $options: "i",
            },
          },
        ],
      },
      {
        Surface: { $gte: 400 },
      },
    ],
  },
}); */

// db.sportifs.find();

// Questions 3 :
/* db.sportifs.aggregate([
  {
    $match: {
      "Sports.Jouer": {
        $regex: "hand ball",
        $options: "i",
      },
    },
  },
  {
    $project: {
      IdSportif: 1,
      Nom: 1,
    },
  },
]); */

// Question 4 :
/* db.sportifs.aggregate([
  {
    $match: {
      "Sports.Jouer": null,
    },
  },
  {
    $project: {
      IdSportif: 1,
      Nom: 1,
    },
  },
]); */

// Question 5 :
/* db.gymnases.aggregate([
  {
    $match: {
      "Seances.Jour": { $not: { $regex: "dimanche", $options: "i" } },
    },
  },
]); */

// Question 6 :
// TODO : Question à faire

// Question 7 :
// FIXME : Corriger la question
/* db.sportifs.aggregate([
  {
    $match: {
      $and: [
        {
          $not: { "Sports.Jouer": { $eq: null } },
        },
        {
          $not: { "Sports.Entrainer": { $eq: null } },
        },
      ],
    },
  },
]); */

// Question 8 :
// FIXME : Corriger la question
/* db.sportifs.aggregate([
  {
    $match: {
      Nom: { $regex: "Kervadec", $options: "i" },
    },
  },
]); */

// Question 9 :
// TODO : Question à faire

// Question 10 :
// TODO : Question à faire

// Question 11 :
// TODO : Question à faire
