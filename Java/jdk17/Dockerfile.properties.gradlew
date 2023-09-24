FROM adoptopenjdk:17-jdk-hotspot-bionic AS build

WORKDIR /app

# Copiar el archivo gradle.properties personalizado al directorio /root/.gradle/
COPY gradle.properties /root/.gradle/

COPY . .

RUN ./gradlew clean build

FROM adoptopenjdk:17-jre-hotspot-bionic

WORKDIR /app

COPY --from=build /app/build/libs/myapp.jar .

CMD ["java", "-jar", "myapp.jar"]