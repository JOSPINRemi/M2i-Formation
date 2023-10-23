export class Morpion {
  constructor() {
    this.grid = [
      [null, null, null],
      [null, null, null],
      [null, null, null],
    ];
  }

  displayGrid() {
    for (let i = 0; i < this.grid.length; i++) {
      //   for (let j = 0; j < this.grid[0].length; j++) {
      //     console.log(this.grid[i][j]);
      //   }
      console.log(this.grid[i]);
    }
  }

  playerMove(line, column, icon) {
    this.grid[line][column] = icon;
  }

  isWon() {
    for (let i = 0; i < this.grid.length; i++) {
      for (let j = 0; j < this.grid[0].length; j++) {
        if (this.grid[i][j] === null) {
          return false;
        }
      }
    }
  }
}
