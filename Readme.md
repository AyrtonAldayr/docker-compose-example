
# Repositorio de Ejemplos de Docker

Este repositorio contiene ejemplos de Docker para ayudarte a comprender y utilizar Docker Compose de manera efectiva.

## Despliegue

Para desplegar este proyecto, ejecuta el siguiente comando:

```bash
docker-compose -p myapp -f /ruta/al/archivo/docker-compose.yml up
```

Este comando utiliza Docker Compose para levantar los servicios definidos en el archivo `docker-compose.yml`. El argumento `-p` establece el nombre del proyecto, mientras que `-f` especifica la ruta al archivo de configuración.

Ejemplo:

```bash
docker-compose -p mysql_webflux-v1 -f ./MySql/docker-compose.yaml up -d
```

Este comando despliega los servicios definidos en el archivo `docker-compose.yaml` ubicado en la carpeta `MySql`. El argumento `-d` ejecuta los servicios en segundo plano.

Ejemplo de eliminación:

```bash
docker-compose -p mongodb-v2 -f ~/Documents/Fuentes/GitHub/docker-compose-example/MongoDB/docker-compose.v2.yml down
```

Este comando detiene y elimina los servicios definidos en el archivo `docker-compose.v2.yml` ubicado en la carpeta `MongoDB`. El argumento `-p` establece el nombre del proyecto.

Ejemplo de un comando si se ha realizado un cambio en el Docker Compose o Docker File: Agregar "--build"

```bash
docker-compose -p myapp-v1 -f ~/docker/docker-compose.yaml up --build -d
```

Este comando reconstruye las imágenes de los servicios definidos en el archivo `docker-compose.yaml` ubicado en la carpeta `docker`. El argumento `--build` asegura que se construyan las imágenes actualizadas antes de iniciar los servicios.

Espero que esta guía rápida te ayude a comprender y utilizar Docker Compose de manera efectiva.