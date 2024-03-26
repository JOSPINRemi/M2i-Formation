# Exercice : Création et publication d'une image sur DockerHub

1. Créer un conteneur à partir d'une image

```
docker pull nginx
docker images
docker run -d -p 8080:80 --name website-container nginx
docker ps
http://localhost:8080
```

2. Ajouter un site web au conteneur

```
docker exec -it website-container /bin/bash
cd /usr/share/nginx/html
apt upgrade
apt update
apt install nano
nano index.html
```

3. Créer une image à partir du conteneur

```
docker commit website-container website-image
docker login
docker tag website-image jospinremi/website-image
```

4. Publier l'image créée sur DockerHub

```
docker push jospinremi/website-image
```
