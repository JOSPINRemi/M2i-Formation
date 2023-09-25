"use strict";
var STATUS;
(function (STATUS) {
    STATUS[STATUS["CADRE"] = 0] = "CADRE";
    STATUS[STATUS["SALARIE"] = 1] = "SALARIE";
    STATUS[STATUS["COMMERCIAL"] = 2] = "COMMERCIAL";
    STATUS[STATUS["BLABLA"] = 3] = "BLABLA";
})(STATUS || (STATUS = {}));
let myStatusC = STATUS.CADRE;
let myStatusD = 2;
let myStatusE = STATUS[3];
console.log(myStatusC);
console.log(myStatusD);
console.log(myStatusE);
let myObjectWithEnum = {
    name: "Toto",
    role: STATUS.CADRE,
    isCommercial: function () {
        return this.role === STATUS.COMMERCIAL;
    },
};
console.log(`Mon utilisateur est un commercial ? ${myObjectWithEnum.isCommercial()}`);
const myFunction = (arg) => {
    console.log(arg.length);
};
myFunction("Bonjour");
myFunction(3);
console.log("##### UNKNOWN #####");
let str;
let strAny;
let hello = "Bonjour";
let myNumber = 42;
str = myNumber;
strAny = hello;
console.log(strAny.length);
console.clear();
if (typeof str == "string") {
    console.log(str.length);
    console.log(typeof str);
}
else {
    console.log(str);
    console.log(typeof str);
}
function afficherMessage() {
    console.log("Bonjour, monde !");
}
const resultat = afficherMessage();
console.log(typeof resultat);
let operation;
operation = function (a, b) {
    return a + b;
};
const calcul = operation(5, 3);
console.log(calcul);
let operation2;
operation2 = function (a, b) {
    return a + b;
};
const calcul2 = operation2(5, 5);
function saluer(nom) {
    if (nom) {
        console.log(`Bonjour, ${nom}`);
    }
    else {
        console.log("Bonjour !");
    }
}
saluer();
saluer("Alice");
function multiplier(a, b = 2) {
    return a * b;
}
const resultat1 = multiplier(5, undefined);
console.log(resultat1);
const resultat2 = multiplier(5, 3);
console.log(resultat2);
function afficherInfo(nom = "Inconnu", age) {
    if (age !== undefined) {
        console.log(`Nom: ${nom}, Age: ${age}`);
    }
    else {
        console.log(`Nom: ${nom}`);
    }
}
afficherInfo();
afficherInfo("Alice");
afficherInfo("Bob", 30);
let myTitleHTML = document.querySelector("#title");
let myTitleHTML2 = document.querySelector("#title");
let myTitle = document.querySelector("#title");
console.log(myTitleHTML.textContent);
console.log(myTitleHTML2.textContent);
myTitle.textContent = "Fin démo Typescript";
function onFormSubmit(event) {
    event.preventDefault();
}
let monTexte = "";
function onInputChange(event) {
    monTexte = event.target.value;
    monTexte = event.target.value;
}
