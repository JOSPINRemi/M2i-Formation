docker build --no-cache -t testreact .
docker run -p 8085:80 -d testreact
