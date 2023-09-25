export class Student {
  constructor(lN = "Doe", fN = "John") {
    this.lastName = lN;
    this.firstName = fN;
    this.notes = {};
    console.log(`L'étudiant ${lN} ${fN} a été ajouté correctement`);
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
    if (this.notes.hasOwnProperty(m)) {
        console.log(`La matière ${m} existe déjà`);
    } else {
        this.notes[m] = [];
        console.log(`La matière ${m} a été ajoutée correctement`);
    }
  }
  addNote(m, n) {
    if (this.notes.hasOwnProperty(m)) {
      this.notes[m].push(n);
      console.log(`La note ${n} a été ajoutée correctement à la matière ${m}`)
    } else {
      console.log(
        `La matière ${m} n'existe pas veuillez la créer préalablement`
      );
    }
  }
}
