import { input } from "../tools.js";
import { Morpion } from "./Morpion.js";

export class Ihm {
  async play() {
    console.log("Bienvenue sur le jeu du morpion");
    const m = new Morpion();
    let player = true;
    let playerIcon = "";
    let column, line;
    do {
      console.log("Voici la grille");
      m.displayGrid();
      console.log(`C'est au tour du joueur ${player === true ? "1" : "2"}`);
      column = await input("Saisir la colonne dans laquelle jouer: ");
      line = await input("Saisir la ligne dans laquelle jouer: ");
      playerIcon = player === true ? "X" : "O";
      m.playerMove(line, column, playerIcon);
      player = !player;
    } while (m.isWon);
  }
}
