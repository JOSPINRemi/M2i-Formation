Créer un conteneur qui contient un serveur web basé sur apache et qui contient un site web
Tuer le conteneur
Recréer un conteneur basé sur nginx et qui contient aussi le site web

solution : utiliser un volume

```
docker volume create website
docker volume ls

docker images

docker run -d -p 8080:80 --name apache-website -v website:/usr/local/apache2/htdocs/ httpd
docker ps

http://localhost:8080

docker cp C:\Users\Administrateur\Desktop\M2i\M2i-Formation-CDA\Docker\exercices\mywebsite\. apache-website:/usr/local/apache2/htdocs/

docker stop apache-website



docker run -d -p 8081:80 --name nginx-website -v website:/usr/share/nginx/html nginx
docker ps
```
