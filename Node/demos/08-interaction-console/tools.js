import readline from "readline";

export function input(message) {
  const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout,
  });

  return new Promise((resolve) => {
    rl.question(message, (answer) => {
      rl.close();
      resolve(answer);
    });
  });
}

// (async () => {
//   let personne = {};
//   personne.nom = await input("Quel est votre nom: ");
//   personne.prenom = await input("Quel est votre prénom: ");
//   console.log(personne);
// })();
