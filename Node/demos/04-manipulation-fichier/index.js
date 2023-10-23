import { stat, readFile, writeFile, appendFile } from "fs";
import fsPromise from "fs/promises";
import path from "path";

const monFichier = "./hello.txt";

stat(monFichier, (error, stats) => {
  if (error) {
    console.log(error.message);
  }
  if (stats.isFile()) {
    console.log("C'est un fichier");
  }
  console.log(stats.size);
});

console.log("Dossier parent : ", path.dirname(monFichier));

console.log(
  "Nom fichier : ",
  path.basename(monFichier),
  "extension : ",
  path.extname(monFichier)
);

console.log("Chemin absolu : ", path.resolve(monFichier));

readFile(monFichier, { encoding: "utf-8" }, (error, data) => {
  console.log(data);
});

async function readMyFileAsync(file) {
  let result = "";
  try {
    result = await fsPromise.readFile(file, { encoding: "utf-8" });
  } catch (error) {
    console.error(error);
    return;
  }
  return result;
}
let myResult = await readMyFileAsync(monFichier);
console.log("Promesse : ", myResult);

let phrase = "J'adore les chips\net les glaces";

writeFile(
  "./ecriture.txt",
  phrase,
  {
    encoding: "utf-8",
    flag: "a+",
  },
  (err) => {
    if (err) {
      console.error(err);
      return;
    }
  }
);

writeFile("./ecriture.txt", "oui, ça va", {
  encoding: "utf-8",
  flag: "a",
});

appendFile("./ecriture.txt", "banana", (err) => {
  if (err) {
    console.error(err);
  }
  return;
});
