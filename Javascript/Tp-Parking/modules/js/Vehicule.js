export class Vehicule {
  constructor(immatriculation, inTime) {
    this.marque = "marque";
    this.modele = "modele";
    this.kilometrage = 0;
    this.annee = 0;
    this.immatriculation = immatriculation;
    this.inTime = inTime;
    this.outTime = undefined;
  }

  display() {
    return `${this.marque} ${this.modele} ${this.kilometrage} ${this.annee}`;
  }
}
