
# Repositorio de Ejemplos de Docker




## Despliegue

To deploy this project run

```bash
  docker-compose -p myapp -f /ruta/al/archivo/docker-compose.yml up
```

Example

```bash
  docker-compose -p mysql_webflux-v1 -f ./MySql/docker-compose.yaml up -d
```

Example delete

```bash
  docker-compose -p mongodb-v2 -f ~/Documents/Fuentes/GitHub/docker-compose-example/MongoDB/docker-compose.v2.yml down
```

Example of a command if a change has been made to the Docker Compose or Docker File - Add "--build"

```bash
  docker-compose -p myapp-v1 -f ~/docker/docker-compose.yaml up --build -d
```