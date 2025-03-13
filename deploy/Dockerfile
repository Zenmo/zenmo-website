# syntax=docker/dockerfile:1.7-labs
# for COPY --exclude support

# Use Node.js to build
FROM node:23 AS node
RUN mkdir -p /app/frontend
WORKDIR /app/frontend

# First put only dependencies in the image so they are cached in a docker layer
COPY package.json yarn.lock ./
RUN --mount=type=cache,target=/usr/local/share/.cache/yarn yarn install

COPY --exclude=dist --exclude=node_modules ./ ./
RUN yarn run build


# Use Caddy to serve static files
FROM caddy:2.8.4

WORKDIR /srv

COPY --from=node /app/frontend/dist /srv

EXPOSE 80

CMD caddy file-server
