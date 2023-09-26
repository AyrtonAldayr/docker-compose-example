
FROM alpine:3.18.3 AS build
RUN apk add --no-cache openjdk17 gradle
WORKDIR /app
COPY . .
COPY path/to/gradle.properties .
RUN gradle build

FROM alpine:3.18.3
RUN apk add --no-cache openjdk17
WORKDIR /app
COPY --from=0 /app/build/libs/myapp.jar .
CMD ["/usr/bin/java", "-jar", "myapp.jar"]
