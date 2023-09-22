export class Student {
  constructor(lN = "Doe", fN = "John") {
    this.lastName = lN;
    this.firstName = fN;
    this.notes = {};
  }

  get getLastName() {
    return this.lastName;
  }
  set setLastName(lN) {
    this.lastName = lN;
  }

  get getFirstName() {
    return this.firstName;
  }
  set setFirstName(fN) {
    this.firstName = fN;
  }

  get getNotes() {
    return this.notes;
  }
  addMatiere(m) {
    this.notes[m] = [];
  }
  addNote(m, n) {
    if (this.notes.hasOwnProperty(m)) {
      this.notes[m].push(n);
    } else {
      console.log(`La matière ${m} n'existe pas veuillez la créer préalablement`);
    }
  }
}
