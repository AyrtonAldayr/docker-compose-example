# Conexión a un contenedor Docker de PostgreSQL

Este archivo README te guiará a través de los pasos necesarios para conectarte a un contenedor Docker de PostgreSQL y ejecutar consultas SQL básicas, como listar las bases de datos, las tablas y realizar un SELECT en las tablas existentes.

## Requisitos previos
Antes de comenzar, asegúrate de tener instalado Docker en tu máquina. Puedes descargar Docker desde el siguiente enlace: [https://www.docker.com/get-started](https://www.docker.com/get-started)

## Paso 1: Descargar la imagen de PostgreSQL
Para comenzar, necesitarás descargar la imagen de PostgreSQL desde Docker Hub. Puedes hacerlo ejecutando el siguiente comando en tu terminal:

```
docker pull postgres
```

## Paso 2: Crear y ejecutar un contenedor de PostgreSQL
Una vez que hayas descargado la imagen de PostgreSQL, puedes crear y ejecutar un contenedor utilizando el siguiente comando:

```
docker run --name mi-postgres -e POSTGRES_PASSWORD=mi-contraseña -p 5432:5432 -d postgres
```

Este comando creará un contenedor llamado "mi-postgres" con una contraseña especificada por ti. Además, el puerto 5432 del contenedor se mapeará al puerto 5432 de tu máquina local.

## Paso 3: Conectarse al contenedor de PostgreSQL
Para conectarte al contenedor de PostgreSQL, puedes utilizar una herramienta de administración de bases de datos como pgAdmin o puedes utilizar la línea de comandos.

### Conexión utilizando la línea de comandos
Si prefieres utilizar la línea de comandos, puedes ejecutar el siguiente comando para conectarte al contenedor de PostgreSQL:

```
docker exec -it mi-postgres psql -U postgres
```

Esto te permitirá ingresar al contenedor y ejecutar comandos SQL.

### Conexión utilizando pgAdmin
Si prefieres utilizar pgAdmin, puedes descargarlo desde el siguiente enlace: [https://www.pgadmin.org/download/](https://www.pgadmin.org/download/)

Una vez que hayas instalado pgAdmin, puedes agregar un nuevo servidor y configurarlo con la siguiente información:

- Host: localhost
- Port: 5432
- Username: postgres
- Password: la contraseña que especificaste al crear el contenedor

## Paso 4: Ejecutar consultas SQL básicas
Una vez que estés conectado al contenedor de PostgreSQL, puedes ejecutar consultas SQL básicas. Aquí hay algunos ejemplos:

- Listar las bases de datos:

```
\l
```

- Conectarse a una base de datos específica:

```
\c nombre_de_la_base_de_datos
```

- Listar las tablas en la base de datos actual:

```
\dt
```

- Realizar un SELECT en una tabla existente:

```
SELECT * FROM nombre_de_la_tabla;
```

Recuerda reemplazar "nombre_de_la_base_de_datos" y "nombre_de_la_tabla" con los nombres reales de tu base de datos y tabla.

¡Eso es todo! Ahora estás listo para conectarte a un contenedor Docker de PostgreSQL y ejecutar consultas SQL básicas. ¡Diviértete explorando y aprendiendo más sobre PostgreSQL!
