import { Person } from "./classes/Person.js";
const contacts = document.querySelector("#contacts");
const addButton = document.querySelector("#addButton");
let contactList = [];
contactList.push(new Person("john", "doe", new Date(), "john.doe@email.com", "+33 9 62 37 81 69"));
function displayContacts() {
    let affichage;
    affichage = "<ul>";
    contactList.forEach((contact) => {
        affichage += `<li>${contact.firstname
            .charAt(0)
            .toUpperCase()}${contact.firstname.slice(1)} ${contact.lastname.toUpperCase()}</li>`;
    });
    affichage += "</ul>";
    contacts.innerHTML = affichage;
}
window.onload = displayContacts();
addButton.addEventListener("click", () => {
    contactList.push(new Person("matt", "smith", new Date(), "matt.smith@email.com", "+33 1 62 37 81 69"));
    displayContacts();
});
