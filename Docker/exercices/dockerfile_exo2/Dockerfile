FROM nginx

WORKDIR /usr/share/nginx/html

RUN rm -f ./*

RUN apt upgrade && apt update && apt install -y git 

RUN git clone https://github.com/withaarzoo/3D-Rotate-Tube.git .

EXPOSE 80

CMD ["nginx", "-g", "daemon off;"]

# docker build -t exo2 .
# docker run -p 3003:80 -d exo2