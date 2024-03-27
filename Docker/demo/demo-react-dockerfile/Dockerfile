# Image de départ
FROM node AS build

WORKDIR /app

# Copie de package.json et package-lock.json
COPY package*.json ./

# Installation des dépendances
RUN npm install

COPY . .

# Build de l'application
RUN npm run build


# Pour mettre notre application sur un serveur
FROM nginx

COPY --from=build /app/build /usr/share/nginx/html

EXPOSE 80

CMD ["nginx", "-g", "daemon off;"]