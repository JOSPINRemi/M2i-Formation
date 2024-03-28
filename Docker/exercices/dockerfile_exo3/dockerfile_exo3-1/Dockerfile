FROM node AS build

WORKDIR /app

COPY package*.json ./

RUN npm install

COPY . .

RUN npm run build


FROM nginx

WORKDIR /usr/share/nginx/html

RUN rm -f ./*

COPY --from=build /app/build ./

EXPOSE 80

CMD [ "nginx", "-g", "daemon off;" ]