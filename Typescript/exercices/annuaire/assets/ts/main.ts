import { Person } from "./classes/Person.js";

/**
 * Contacts
 */
const contacts = document.querySelector("#contacts") as HTMLDivElement;
const addButton = document.querySelector("#addButton") as HTMLButtonElement;

/**
 * Détails
 */
const firstname = document.querySelector("#firstname") as HTMLInputElement;
const lastname = document.querySelector("#lastname") as HTMLInputElement;
const dateofbirth = document.querySelector("#dateofbirth") as HTMLInputElement;
const email = document.querySelector("#email") as HTMLInputElement;
const phonenumber = document.querySelector("#phonenumber") as HTMLInputElement;

const detailsform = document.querySelector("#detailsform") as HTMLFormElement;

const editButton = document.querySelector("#editButton") as HTMLButtonElement;
const deleteButton = document.querySelector(
  "#deleteButton"
) as HTMLButtonElement;

let contactList: Person[] = [];
contactList.push(
  new Person(
    "john",
    "doe",
    new Date(),
    "john.doe@email.com",
    "+33 9 62 37 81 69"
  )
);

function displayContacts(): any {
  let affichage: string;
  affichage = "<div>";
  contactList.forEach((contact) => {
    affichage += `<button type="button" id="person${
      contact.id
    }" class="contact">${contact.firstname
      .charAt(0)
      .toUpperCase()}${contact.firstname.slice(
      1
    )} ${contact.lastname.toUpperCase()}</button>`;
  });
  affichage += "</div>";
  contacts.innerHTML = affichage;

  addEventOnContact();
}

window.onload = displayContacts();

addButton.addEventListener("click", () => {
  contactList.push(
    new Person(
      firstname.value.trim(),
      lastname.value.trim(),
      new Date(dateofbirth.value),
      email.value.trim(),
      phonenumber.value.trim()
    )
  );
  detailsform.reset();
  displayContacts();
});

function addEventOnContact() {
  contactList.forEach((contact) => {
    let personBtn = document.querySelector(
      `#person${contact.id}`
    ) as HTMLButtonElement;
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
      } else {
        addButton.disabled = true;
        personBtn.style.color = "white";
        personBtn.style.backgroundColor = "blue";
        editButton.disabled = false;
        deleteButton.disabled = false;
      }
    });
  });
}
