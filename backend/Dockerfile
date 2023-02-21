
# Build stage
FROM eclipse-temurin:17-jdk-alpine AS build

ARG BACKEND_PORT
ENV BACKEND_PORT=$BACKEND_PORT

WORKDIR /backend

COPY mvnw pom.xml ./
COPY .mvn .mvn
RUN ./mvnw dependency:go-offline

COPY ./src ./src
RUN ./mvnw clean install


# Run stage
FROM eclipse-temurin:17-jre-alpine

ARG BACKEND_PORT
ENV BACKEND_PORT=$BACKEND_PORT

WORKDIR /backend

COPY --from=build /backend/target/*.jar /backend/app.jar

EXPOSE $BACKEND_PORT

ENTRYPOINT [ "java", "-jar", "/backend/app.jar" ]
