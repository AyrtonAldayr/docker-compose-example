
# Conexión a un contenedor Docker de PostgreSQL

Este archivo README te guiará a través de los pasos necesarios para conectarte a un contenedor Docker de PostgreSQL y ejecutar consultas SQL básicas, como listar las bases de datos, las tablas y realizar un SELECT en las tablas existentes.

## Requisitos previos

Antes de comenzar, asegúrate de tener instalado Docker y Docker Compose en tu máquina. Puedes descargar Docker desde el siguiente enlace: [https://www.docker.com/get-started](https://www.docker.com/get-started) y Docker Compose desde el siguiente enlace: [https://docs.docker.com/compose/install/](https://docs.docker.com/compose/install/).

## Paso 1: Configurar `docker-compose.yml`

Primero, necesitas configurar el archivo `docker-compose.yml`. Asegúrate de tener el siguiente contenido en tu archivo `docker-compose.yml`:

```yaml
version: '3.8'

volumes:
  postgres-data:

networks:
  mynetwork:
    driver: bridge

services:
  postgres:
    image: postgres:alpine3.19
    restart: always
    environment:
      POSTGRES_PASSWORD: root
      PGDATA: /var/lib/postgresql/data/pgdata
    volumes:
      - postgres-data:/var/lib/postgresql/data
      - ./init.sql:/docker-entrypoint-initdb.d/init.sql
    ports:
      - "54320:5432"
    networks:
      - mynetwork
```

Este archivo configurará un servicio de PostgreSQL que utilizará el archivo `init.sql` para inicializar la base de datos.

## Paso 2: Crear el archivo de inicialización SQL

Crea un archivo `init.sql` en el mismo directorio donde se encuentra tu archivo `docker-compose.yml` con el siguiente contenido:

```sql
CREATE USER usuario1 WITH PASSWORD 'usuario1';
CREATE DATABASE db_pruebas;
ALTER USER usuario1 CREATEDB CREATEROLE SUPERUSER;
```

Este archivo creará un usuario y una base de datos iniciales cuando se inicie el contenedor.

## Paso 3: Iniciar el contenedor con Docker Compose

Para iniciar el contenedor de PostgreSQL utilizando Docker Compose, ejecuta el siguiente comando en tu terminal:

```sh
docker-compose up -d
```

Este comando creará y ejecutará el contenedor de PostgreSQL en segundo plano.

## Paso 4: Conectarse al contenedor de PostgreSQL

Para conectarte al contenedor de PostgreSQL, puedes utilizar una herramienta de administración de bases de datos como pgAdmin o puedes utilizar la línea de comandos.

### Conexión utilizando la línea de comandos

Si prefieres utilizar la línea de comandos, puedes ejecutar el siguiente comando para conectarte al contenedor de PostgreSQL:

```sh
docker exec -it nombre_del_servicio psql -U usuario1 -d db_pruebas
```

Esto te permitirá ingresar al contenedor y ejecutar comandos SQL.

### Conexión utilizando pgAdmin

Si prefieres utilizar pgAdmin, puedes descargarlo desde el siguiente enlace: [https://www.pgadmin.org/download/](https://www.pgadmin.org/download/).

Una vez que hayas instalado pgAdmin, puedes agregar un nuevo servidor y configurarlo con la siguiente información:

- Host: localhost
- Port: 54320
- Username: usuario1
- Password: usuario1
- Database: db_pruebas

## Paso 5: Ejecutar consultas SQL básicas

Una vez que estés conectado al contenedor de PostgreSQL, puedes ejecutar consultas SQL básicas. Aquí hay algunos ejemplos:

- Listar las bases de datos:

```sql
\l
```

- Conectarse a una base de datos específica:

```sql
\c db_pruebas
```

- Listar las tablas en la base de datos actual:

```sql
\dt
```

- Realizar un SELECT en una tabla existente:

```sql
SELECT * FROM nombre_de_la_tabla;
```

Recuerda reemplazar "nombre_de_la_tabla" con el nombre real de tu tabla.

¡Eso es todo! Ahora estás listo para conectarte a un contenedor Docker de PostgreSQL y ejecutar consultas SQL básicas. ¡Diviértete explorando y aprendiendo más sobre PostgreSQL!
