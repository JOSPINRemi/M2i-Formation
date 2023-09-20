// URL de l'API que nous allons interroger
// const apiUrl = "https://jsonplaceholder.typicode.com/posts/1";
const apiUrl = "https://pokeapi.co/api/v2/pokemon/25"

// Utilisation du fetch

fetch(apiUrl)
  .then((response) => {
    // Vérifier si la réponse est OK (HTTP 200)
    if (!response.ok) {
      throw new Error(`La requête a échouée avec un statut ${response.status}`);
    }

    // Parser la réponse en JSON
    return response.json();
  })
  .then((data) => {
    // Traitement  des données de la réponse
    console.group("Données reçues : ");
    console.log(data);
    console.groupEnd();
  })
  .catch((error) => {
    // Gestion des erreurs
    console.error("Une erreur : " + error);
  });
