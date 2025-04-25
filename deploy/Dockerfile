# syntax=docker/dockerfile:1.7-labs

# Use JDK to build the Kobweb project
FROM eclipse-temurin:21 AS builder
RUN apt-get update && apt-get install -y \
    libglib2.0-0t64 \
    libnss3 \
    libnspr4 \
    libdbus-1-3 \
    libatk1.0-0t64 \
    libatk-bridge2.0-0t64 \
    libatspi2.0-0t64 \
    libx11-6 \
    libxcomposite1 \
    libxdamage1 \
    libxext6 \
    libxfixes3 \
    libxrandr2 \
    libgbm1 \
    libxkbcommon0 \
    libasound2t64

WORKDIR /app

COPY . ./

RUN chmod +x ./gradlew
RUN --mount=type=cache,target=/root/.gradle \
    --mount=type=cache,target=/root/.cache \
    --mount=type=cache,target=/app/.gradle \
    ./gradlew site:kobwebExport -PkobwebExportLayout=STATIC -PkobwebReuseServer=false -PkobwebBuildTarget=RELEASE

# Use Caddy to serve static files
FROM caddy:2.8.4
WORKDIR /srv

COPY --from=builder /app/site/.kobweb/site /srv

EXPOSE 80

CMD ["caddy", "run", "--config", "/etc/caddy/Caddyfile"]
