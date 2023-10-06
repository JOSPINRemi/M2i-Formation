# Exercice d'Application des notions de bases de React
Réaliser une application avec React permettant à un utilisateur de pouvoir saisir et visualiser des tâches sous la forme d'une liste de tâches.

## Vous devrez avoir pour cela plusieurs composants:
- Un composant de formulaire (avec validation en temps réel et réactivité) pour l'ajout des tâches (qui contiendront comme information leur nom, leur deadline sous la forme d'une date, ainsi que leur statut de completion - finie ou non)
- Un composant d'affichage de la tâche qui se verra répété pour chacune des tâches. En cas de tâche finie, il sera possible de pouvoir supprimer la tâche grâce à une croix.
- Un bouton permettant de voir le statut de la tâche et de la passer à finie ou à en cours

## Vis à vis des contraintes de hooks React:
- Pour centraliser les données, vous aurez besoin de faire appel au hook useContext pour limiter le passage de props.
- Pour permettre le rendu conditionnel du bouton d'ajout d'une todo, vous utiliserez un useEffect
- Pour permettre à votre formulaire de ne pas monopoliser la mémoire, vous récupérerez les informations le concernant via l'utilisation de useRef
- Pour permettre un rendu réactif de votre application, vous aurez également besoin de faire appel à des useState