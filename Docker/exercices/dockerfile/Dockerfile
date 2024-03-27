# Image de départ
FROM nginx

# Information utile
LABEL version="0.1"

MAINTAINER remi

WORKDIR /usr/share/nginx/html

COPY . .

EXPOSE 80

CMD ["nginx", "-g", "daemon off;"]

# Pour construire l'image (avec l'option no cache)
# docker build --no-cache -t exodockerfile .

# Pour tester mon image
# docker run --name exodockerfiletest -p 5555:80 -d exodockerfile