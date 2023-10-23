import { input } from "../tools.js";

export class Ihm {
  constructor() {
    this.personnes = [];
  }

  async menu() {
    let choix = "";
    while (choix !== "q") {
      console.log("1 - Ajouter une personne");
      console.log("2 - Afficher les personnes");
      console.log("q - Quitter ");
      choix = await input("Saisir une option : ");

      switch (choix) {
        case "1":
          let nom = await input("Saisir le nom: ");
          let prenom = await input("Saisir le prénom: ");
          this.personnes.push({ prenom, nom });
          break;
        case "2":
          this.personnes.forEach((p) =>
            console.log(`prénom ${p.prenom} nom ${p.nom}`)
          );
          break;
      }
    }
    console.log("Adios;__;");
  }
}
