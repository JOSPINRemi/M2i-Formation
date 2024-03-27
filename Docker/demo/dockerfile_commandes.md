# Créer un container à partir d'un dockerfile

Dans le terminal :

- Se mettre dans le dossier où est le dockerfile
- Taper les commandes :  
   Pour build l'image (demodockerfile) à partir du dockerfile
  ```powershell
  docker build -t demodockerfile .
  ```
  Pour créer un container (demofirstimage) à partir de l'image (demodockerfile)
  ```powershell
  docker run --name demofirstimage -it demodockerfile sh
  ```
