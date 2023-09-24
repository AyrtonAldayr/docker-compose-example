FROM adoptopenjdk:11-jdk-hotspot-bionic AS build

WORKDIR /app

COPY . .

RUN ./gradlew clean build

FROM adoptopenjdk:11-jre-hotspot-bionic

WORKDIR /app

COPY --from=build /app/build/libs/myapp.jar .

CMD ["java", "-jar", "myapp.jar"]