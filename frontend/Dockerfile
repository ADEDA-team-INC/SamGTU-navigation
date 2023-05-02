
# Installation stage
FROM node:19-alpine AS install

WORKDIR /frontend

COPY package.json package-lock.json ./
RUN npm install


# Development stage
FROM install AS dev

WORKDIR /frontend

COPY src/ ./src
COPY public/ ./public
COPY index.html vite.config.ts tsconfig.json tsconfig.node.json ./

ARG FRONTEND_PORT
ARG BACKEND_URL
ENV FRONTEND_PORT=$FRONTEND_PORT
ENV BACKEND_URL=$BACKEND_URL

ENTRYPOINT [ "sh", "-c", "npm run dev -- --host --port $FRONTEND_PORT" ]


# Build stage
FROM install AS build

WORKDIR /frontend

COPY src/ ./src
COPY public/ ./public
COPY index.html vite.config.ts tsconfig.json tsconfig.node.json ./

ARG BACKEND_URL
ENV BACKEND_URL=$BACKEND_URL

RUN npm run build


# Production run stage
FROM node:19-alpine AS prod

WORKDIR /frontend

RUN npm install -g http-server

COPY --from=build /frontend/dist /frontend/

ARG FRONTEND_PORT
ENV FRONTEND_PORT=$FRONTEND_PORT

ENTRYPOINT [ "sh", "-c", "http-server ./ -p $FRONTEND_PORT" ]
