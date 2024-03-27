```
docker network create mon-reseau
docker network ls

docker run --name machinea -d --network mon-reseau nginx
docker network inspect mon-reseau

docker run --name machineb -d --network mon-reseau nginx
docker network inspect mon-reseau

docker ps

--- --- --- --- --- --- --- ---

Dans 2 terminaux différents :
docker exec -it machinea bash
docker exec -it machineb bash

Dans chacun des termiaux :
apt upgrade
apt-get update && apt-get install -y iputils-ping

--- --- --- --- --- --- --- ---

Dans le terminal de la machine a :
ping machineb

--- --- --- --- --- --- --- ---

Dans le terminal de la machine b :
ping machinea

--- --- --- --- --- --- --- ---

Dans le terminal de départ :
docker run --name machinec -d nginx

--- --- --- --- --- --- --- ---

Dans le terminal de la machine c :
docker exec -it machinec bash
apt upgrade
apt-get update && apt-get install -y iputils-ping
ping machinea

erreur
il faut ajouter machinec au réseau

--- --- --- --- --- --- --- ---

Dans le terminal de départ :
docker network connect mon-reseau machinec

--- --- --- --- --- --- --- ---

Dans le terminal de la machinec :
ping machinea
ping machineb

--- --- --- --- --- --- --- ---

Pour déconnecter la machinec du réseau :
docker network disconnect mon-reseau machinec
```
