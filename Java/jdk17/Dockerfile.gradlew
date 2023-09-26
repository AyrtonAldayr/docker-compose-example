# Primera fase: compilar la aplicación
FROM alpine:3.18.3 AS build

# Instalar OpenJDK 17 y Gradle
RUN apk add --no-cache openjdk17 gradle

# Establecer el directorio de trabajo
WORKDIR /app

# Copiar el código fuente y los archivos de Gradle
COPY . .

# Compilar la aplicación con Gradle
RUN gradle build

# Segunda fase: desplegar la aplicación
FROM alpine:3.18.3

# Instalar OpenJDK 17
RUN apk add --no-cache openjdk17

# Establecer el directorio de trabajo
WORKDIR /app

# Copiar el archivo JAR generado en la primera fase
COPY --from=build /app/build/libs/myapp.jar .

# Ejecutar la aplicación
CMD ["java", "-jar", "myapp.jar"]
