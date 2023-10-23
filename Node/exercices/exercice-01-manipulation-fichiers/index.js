import LineByLine from "n-readlines";
import { mkdirSync } from "fs";

let file = "./arborescence.txt";

let lineReader = new LineByLine(file);
let line = "";

while ((line = lineReader.next())) {
  let directory = line.toString().trim();
  try {
    mkdirSync(directory);
    console.log(`Le répertoire ${directory} a été créé avec succès`);
  } catch (error) {
    console.error(`Erreur lors de la création du dossier ${directory}`);
  }
}
