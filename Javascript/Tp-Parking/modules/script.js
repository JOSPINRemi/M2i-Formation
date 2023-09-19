import { Vehicule } from "./js/Vehicule.js";

const affichage = document.querySelector(".affichage"),
  immat = document.querySelector("#immat"),
  BtnPayer = document.querySelector("#payer"),
  BtnTicket = document.querySelector("#ticket");

let message = "",
  valueImmat,
  prix,
  parking = [];

window.onload = setInterval(() => {
  valueImmat = immat.value;
}, 1);

document.addEventListener("click", () => {
  affichage.innerHTML = message;
});

BtnPayer.addEventListener("click", () => {
  for (let i = 0; i < parking.length; i++) {
    if (parking[i].immatriculation === valueImmat) {
      parking[i].outTime = new Date();
      if (timeInParkingMillis(parking[i]) <= 15) {
        prix = 0.8;
      } else if (
        15 < timeInParkingMillis(parking[i]) &&
        timeInParkingMillis(parking[i]) <= 30
      ) {
        prix = 1.3;
      } else if (
        30 < timeInParkingMillis(parking[i]) &&
        timeInParkingMillis(parking[i]) <= 45
      ) {
        prix = 1.7;
      } else if (timeInParkingMillis(parking[i]) > 45) {
        prix = 6;
      }
      message = `Le prix à payer pour le véhicule ${valueImmat} est de ${prix} €`;
    }
  }
  // message = `Le véhicule ${valueImmat} n'existe pas!`;
  // console.log("BtnPayer");
  // console.table(parking);
});

BtnTicket.addEventListener("click", () => {
  parking.push(new Vehicule(valueImmat, new Date()));
  message = `Veuillez prendre votre ticket pour le véhicule ${valueImmat}.`;
  // message = `Le véhicule ${valueImmat} est déjà dans le parking`;
  // console.log("BtnTicket");
  // console.table(parking);
});

function timeInParkingMillis(vehicule) {
  return Math.round((vehicule.outTime - vehicule.inTime) / 60000);
}
