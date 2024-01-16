use("book");
// db.books.find();

// Read :
// Recherche id 45
// db.books.find({ _id: 45 });

// Limiter à 5
// db.books.find().limit(5);

// Avec 2 auteurs
// db.books.find({ authors: { $size: 2 } });

// Nombre de page supérieur ou égal à 400
// db.books.find({ pageCount: { $gte: 400 } });

// id == 55, 75 et 120
// db.books.find({ _id: { $in: [55, 75, 120] } });

// Avec 2 auteurs, tri par titre puis _id en cas d'égalité de titre
// db.books.find({ authors: { $size: 2 } }).sort({ title: 1, _id: -1 });

// Avec 2 auteurs, tri par titre puis _id en cas d'égalité de titre et limiter aux 3 premiers résultats
// db.books
//   .find({ authors: { $size: 2 } })
//   .skip(10)
//   .sort({ title: 1, _id: -1 })
//   .limit(3);

// Les livres dont l'id est entre 26 et 49
// db.books.find({ $and: [{ _id: { $gt: 25 } }, { _id: { $lt: 50 } }] }).count();

// Affiche uniquement l'id et les auteurs des livre dont l'id est supérieur à 45
// db.books.find({ _id: { $gt: 45 } }, { _id: 1, authors: 1 });

// Affiche toutes les informations sauf les auteurs des livre dont l'id est supérieur à 45
// db.books.find({ _id: { $gt: 45 } }, { authors: 0 });

// Compris dans le tableau
// db.books.find({ categories: { $in: ["Java", "Web Development"] } });

// Les 2 informations
// db.books.find({ categories: { $all: ["Java", "Web Development"] } });

// L'un ou l'autre
// db.books.find({ $or: [{ _id: 19 }, { id: 80 }] });

// Commence par ext sans tenir compte de la case (options i pour insensitive)
// db.books.find({ longDescription: { $regex: "^ext", $options: "i" } });

// Contient distributed sans tenir compte de la case
// db.books.find({ longDescription: { $regex: "Distributed", $options: "i" } });

// Finit par perl sans tenir compte de la case
// db.books.find({ title: { $regex: "Perl$", $options: "i" } });
