import { Person, Student } from "./classes/Person.js";
let person;
person = new Person("Albert", "DUPONT", 45, 5454556);
person.firstname = "Toto";
console.log(person.fullname);
console.log(person.numeroIdNat);
console.log(`Il y a actuellement ${Person.count} personnes`);
let personArray = [];
personArray.push(person);
let myStudent;
myStudent = new Student("Titi", "TATA", 45, 545215, true);
console.log(myStudent.toString());
console.log(`Il y a actuellement ${Person.count} personnes`);
console.clear();
let monObjA = {
    firstname: "Albert",
    lastname: "DUPONT",
};
let monObjB = {
    firstname: "Albert",
    lastname: "DUPONT",
    numeroIdNat: 123456,
    acheter() {
        if (this.firstname === "blabla") {
            return 10;
        }
        else {
            return 25;
        }
    },
};
let monObjC = {
    firstname: "Thierry",
    lastname: "DUPONT",
    pointFid: 15
};
console.log(monObjC.firstname);
