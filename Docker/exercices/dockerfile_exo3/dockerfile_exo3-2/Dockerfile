FROM node

WORKDIR /app

ENV PORT=3002

COPY package*.json ./

RUN npm install

COPY . .

EXPOSE ${PORT}

CMD [ "node", "app.js" ]

# docker build -t apptodo . --no-cache
# docker run -p 5000:3001 -d apptodo


# Avec une variable d'environnement
# docker build -t apptodowithenv . --no-cache
# docker run -p 5001:3002 -d apptodowithenv

# docker run -e PORT=5000 -p 5005:5000 -d apptodowithenv