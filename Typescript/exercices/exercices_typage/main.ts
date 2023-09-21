// 1.
let userName: string = "RJos";

// 2.
let userAge: number = 23;

// 3.
let isLogin: boolean = false;

// 4.
let userNames: Array<string> = [];
userNames.push(userName);
console.log(`userNames : ${userNames}`);

// 5.
let person: object;
person = {
  firstName: "Dupont",
  age: 20,
  isLoggedIn: true,
};
console.group("Est-il possible d'afficher la valeur age via console.log ?");
console.log(`Oui, il est possible d'afficher l'âge via console.log
La person a ${person.age} ans\n
Mais une erreur est présente :
Property 'age' does not exist on type 'object'`);
console.groupEnd();

// 6.
let person1 = {
  firstName: "Dupont",
  age: 20,
  isLoggedIn: true,
};
console.log(`La person1 a ${person1.age} ans`);

// 7.
let person2 = {
  firstName: "Dupont",
  age: 20,
  isLoggedIn: true,
};
console.log(`La person2 a ${person2.age} ans`);

// 8.
let infos: [string, number];