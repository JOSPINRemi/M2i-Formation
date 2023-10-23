const fs = require("fs");

let persons = [
  { firstname: "toto", lastname: "dupont" },
  { firstname: "titi", lastname: "dupond" },
];

let file = "./data.json";

fs.writeFileSync(file, JSON.stringify(persons));

let personsFromFile = [];
const content = fs.readFileSync(file).toString();
personsFromFile = JSON.parse(content);
console.log(personsFromFile);
