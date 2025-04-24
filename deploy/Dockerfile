# syntax=docker/dockerfile:1.7-labs

# Use JDK to build the Kobweb project
FROM eclipse-temurin:21 AS builder
WORKDIR /app/site

RUN ls -al
RUN pwd

COPY . ./


RUN chmod +x ./gradlew
RUN --mount=type=cache,target=/root/.gradle \
    --mount=type=cache,target=//root/.cache  \
    --mount=type=cache,target=/app/site/.gradle \
    ./gradlew kobwebExport

# Use Caddy to serve static files
FROM caddy:2.8.4
WORKDIR /srv

COPY --from=builder /site/build/ /srv

EXPOSE 80

CMD caddy file-server
