
# Development stage
FROM node:19-alpine AS dev

ARG FRONTEND_PORT
ENV FRONTEND_PORT=$FRONTEND_PORT

WORKDIR /frontend

COPY package.json package-lock.json ./
RUN npm install

EXPOSE $FRONTEND_PORT

ENTRYPOINT [ "sh", "-c", "npm run dev -- --host --port $FRONTEND_PORT" ]


# Build stage
FROM node:19-alpine AS build

WORKDIR /frontend

COPY package.json package-lock.json ./
RUN npm install

COPY src/ ./src
COPY public/ ./public
COPY index.html postcss.config.cjs tailwind.config.cjs vite.config.js ./

RUN npm run build


# Production run stage
FROM node:19-alpine AS prod

ARG FRONTEND_PORT
ENV FRONTEND_PORT=$FRONTEND_PORT

WORKDIR /frontend

RUN npm install -g http-server

COPY --from=build /frontend/dist /frontend/

EXPOSE $FRONTEND_PORT

ENTRYPOINT [ "sh", "-c", "http-server ./ -p $FRONTEND_PORT" ]
