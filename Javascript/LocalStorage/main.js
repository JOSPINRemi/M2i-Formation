console.log("Local Storage");


// Enregistrer dans le localstorage
const person = {
    name: "toto",
    age: 42
}

localStorage.setItem("people",JSON.stringify(person))
localStorage.setItem("people2",JSON.stringify(person))
localStorage.setItem("people3",JSON.stringify(person))


// Récupérer dans le localstorage

let personStorage = JSON.parse(localStorage.getItem("people"))

console.log(personStorage)

console.log(personStorage.name);

// localStorage.clear();

localStorage.removeItem("people2")