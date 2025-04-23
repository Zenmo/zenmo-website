# syntax=docker/dockerfile:1.7-labs

# Use JDK to build the Kobweb project
FROM eclipse-temurin:21 AS builder
WORKDIR /app/site

COPY gradlew gradlew.bat settings.gradle.kts ./
COPY gradle ./gradle

RUN chmod +x ./gradlew

RUN /gradlew dependencies || true

COPY site ./

RUN ./gradlew kobwebExport

# Use Caddy to serve static files
FROM caddy:2.8.4
WORKDIR /srv

COPY --from=builder /site/build/ /srv

EXPOSE 80

CMD caddy file-server
