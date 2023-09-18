const affichage = document.querySelector(".affichage"),
immat = document.querySelector("#immat"),
BtnPayer = document.querySelector("#payer"),
BtnTicket = document.querySelector("#ticket"),
valueImmat = immat.value

let message,
parking = []

BtnPayer.addEventListener("click", payer())
BtnTicket.addEventListener("click", ticket())

function payer() {
    
}

function ticket() {
    
}

message = `Le véhicule ${valueImmat} n'existe pas!`;
message = `Veuillez prendre votre ticket pour le véhicule ${valueImmat}.`;
message = `Le prix à payer pour le véhicule ${valueImmat} est de {} €`;
message = `Le véhicule ${valueImmat} est déjà dans le parking`;

affichage.innerHTML = message;
