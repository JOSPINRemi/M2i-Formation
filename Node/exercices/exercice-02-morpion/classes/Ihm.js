import { input } from "../tools.js";
import { Morpion } from "./Morpion.js";

export class Ihm {
  async play() {
    console.log("Bienvenue sur le jeu du morpion");
    const m = new Morpion();
    let column, line;
    do {
      console.log("Voici la grille");
      m.displayGrid();
      console.log(
        `C'est au tour du joueur ${m.playerTurn === true ? "1" : "2"}`
      );
      do {
        do {
          column = await input("Saisir la colonne dans laquelle jouer: ");
          if (column < 0 || column > 2) {
            console.log("Saisie invalide");
          }
        } while (column < 0 || column > 2);
        do {
          line = await input("Saisir la ligne dans laquelle jouer: ");
          if (line < 0 || line > 2) {
            console.log("Saisie invalide");
          }
        } while (line < 0 || line > 2);
        if (m.grid[line][column] !== null) {
          console.log("La case est déjà occupée");
        }
      } while (m.grid[line][column] !== null);

      m.playerMove(line, column);
    } while (!m.isWon());
  }
}
