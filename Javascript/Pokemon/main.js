const result = document.querySelector("#result");
const apiUrl = "https://pokeapi.co/api/v2/pokemon/";
let id = 1;
// let numberOfPokemon =
//   prompt(
//     "Voulez vous choisir le nombre de Pokémon à afficher ? (o/n)\nPar défaut il en aura 10"
//   ) === "o"
//     ? prompt("Combien de pokémon voulez-vous afficher ?")
//     : 10;
let numberOfPokemon = 10;
let affichage;
fetch(apiUrl + id)
  .then((response) => {
    if (!response.ok) {
      throw new Error(
        `La requête a échouée avec un statut : ${response.status}`
      );
    }
    return response.json();
  })
  .then((data) => {
    result.appendChild(affichagePokemon(data));
  })
  .catch((error) => {
    console.error("Erreur : " + error);
  });

function affichagePokemon(inData) {
  let pokemon = document.createElement("div");
  pokemon.appendChild(pokemonName(inData.name));
  let pP = pokemonPicture(inData.sprites.front_default, inData.name, "");
  pP.style.width = "50%";
  pokemon.appendChild(pP);
  pokemon.appendChild(pokemonType("Type", inData.types));
  pokemon.appendChild(pokemonFeatures("Taille", `${inData.height} dm`));
  pokemon.appendChild(pokemonFeatures("Poids", `${inData.weight} kg`));
  pokemon.style.display = "flex";
  pokemon.style.flexDirection = "column";
  pokemon.style.alignItems = "center";
  pokemon.style.padding = "0";
  pokemon.style.border = "1px solid black";
  pokemon.style.borderRadius = "10px";
  pokemon.style.backgroundColor = "lightgrey";
  pokemon.style.width = "50%";
  return pokemon;
}

function pokemonName(inTitle) {
  let title = document.createElement("h2");
  let textContent = document.createTextNode(inTitle);
  title.appendChild(textContent);
  return title;
}

function pokemonPicture(inUrlImage, inAlt, inTitle) {
  let image = document.createElement("img");
  image.setAttribute("src", inUrlImage);
  image.setAttribute("alt", inAlt);
  if (inTitle != "") {
    image.setAttribute("title", inTitle);
  }
  return image;
}

function pokemonType(inLabel, inData) {
  let div = document.createElement("div");
  let paragraph = document.createElement("p");
  let bold = document.createElement("b");
  let label = document.createTextNode(`${inLabel} : `);
  bold.appendChild(label);
  paragraph.appendChild(bold);
  div.appendChild(paragraph);
  for (let i = 0; i < inData.length; i++) {
    div.appendChild(
      pokemonPicture(
        inData[i].type.url,
        inData[i].type.name,
        inData[i].type.name
      )
    );
  }
  return div;
}

function pokemonFeatures(inLabel, inData) {
  let paragraph = document.createElement("p");
  let bold = document.createElement("b");
  let label = document.createTextNode(`${inLabel} : `);
  let data = document.createTextNode(inData);
  bold.appendChild(label);
  paragraph.appendChild(bold);
  paragraph.appendChild(data);
  return paragraph;
}
