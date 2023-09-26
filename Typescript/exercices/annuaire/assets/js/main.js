import { Person } from "./classes/Person.js";
/**
 * Contacts
 */
const contacts = document.querySelector("#contacts");
const addButton = document.querySelector("#addButton");
/**
 * Détails
 */
const firstname = document.querySelector("#firstname");
const lastname = document.querySelector("#lastname");
const dateofbirth = document.querySelector("#dateofbirth");
const email = document.querySelector("#email");
const phonenumber = document.querySelector("#phonenumber");
const detailsform = document.querySelector("#detailsform");
const editButton = document.querySelector("#editButton");
const deleteButton = document.querySelector("#deleteButton");
let contactList = [];
contactList.push(new Person("john", "doe", new Date(), "john.doe@email.com", "+33 9 62 37 81 69"));
function displayContacts() {
    let affichage;
    affichage = "<div>";
    contactList.forEach((contact) => {
        affichage += `<button type="button" id="person${contact.id}" class="contact">${contact.firstname
            .charAt(0)
            .toUpperCase()}${contact.firstname.slice(1)} ${contact.lastname.toUpperCase()}</button>`;
    });
    affichage += "</div>";
    contacts.innerHTML = affichage;
    addEventOnContact();
}
window.onload = displayContacts();
addButton.addEventListener("click", () => {
    contactList.push(new Person(firstname.value.trim(), lastname.value.trim(), new Date(dateofbirth.value), email.value.trim(), phonenumber.value.trim()));
    detailsform.reset();
    displayContacts();
});
function addEventOnContact() {
    contactList.forEach((contact) => {
        let personBtn = document.querySelector(`#person${contact.id}`);
        personBtn.addEventListener("click", () => {
            firstname.value = contact.firstname;
            firstname.readOnly = true;
            lastname.value = contact.lastname;
            lastname.readOnly = true;
            email.value = contact.email;
            email.readOnly = true;
            phonenumber.value = contact.phonenumber;
            phonenumber.readOnly = true;
            if (addButton.disabled) {
                addButton.disabled = false;
                detailsform.reset();
                personBtn.style.color = "black";
                personBtn.style.backgroundColor = "";
                editButton.disabled = true;
                deleteButton.disabled = true;
            }
            else {
                addButton.disabled = true;
                personBtn.style.color = "white";
                personBtn.style.backgroundColor = "blue";
                editButton.disabled = false;
                deleteButton.disabled = false;
            }
        });
    });
}
