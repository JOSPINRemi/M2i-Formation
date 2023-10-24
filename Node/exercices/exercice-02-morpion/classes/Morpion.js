export class Morpion {
  constructor() {
    this.grid = [
      [null, null, null],
      [null, null, null],
      [null, null, null],
    ];
    this.playerTurn = true;
  }

  displayGrid() {
    for (let i = 0; i < this.grid.length; i++) {
      console.log(this.grid[i]);
    }
  }

  playerMove(line, column) {
    this.grid[line][column] = this.playerTurn ? "X" : "O";
    this.playerTurn = !this.playerTurn;
  }

  isWon() {
    // for (let i = 0; i < this.grid.length; i++) {
    //   for (let j = 0; j < this.grid[i].length; j++) {}
    // }
    return false;
  }
}
