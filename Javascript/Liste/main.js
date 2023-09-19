const input = document.querySelector("#input");
const addBtn = document.querySelector("#addButton");
const liste = document.querySelector("#liste");
let tab = [];

let affichage;

window.onload = () => {
  if (JSON.parse(localStorage.getItem("liste"))) {
    tab = JSON.parse(localStorage.getItem("liste"));
  }
  displayList();
};

addBtn.addEventListener("click", () => {
  if (input.value != "") {
    tab.push(input.value);
    localStorage.setItem("liste", JSON.stringify(tab));
    displayList();
    input.value = "";
  }
});

function displayList() {
  affichage = "<ul>";
  tab.forEach(
    (produit) =>
      (affichage += `<li>${produit}
        <button id="modifier">
            Modifier
        </button>
        <button id="supprimer">
            Supprimer
        </button>
    </li>`)
  );
  affichage += "</ul>";
  affichage += '<button id="clear">Clear</button>'
  liste.innerHTML = affichage;
}
