
# Build stage
FROM eclipse-temurin:17-jdk-alpine AS build

WORKDIR /backend

COPY mvnw pom.xml ./
COPY .mvn .mvn
RUN /bin/sh ./mvnw dependency:go-offline

COPY ./src ./src
RUN /bin/sh ./mvnw clean install


# Run stage
FROM eclipse-temurin:17-jre-alpine

ENV SPRING_PROFILES_ACTIVE=docker

WORKDIR /backend

COPY --from=build /backend/target/*.jar /backend/app.jar

ENTRYPOINT [ "java", "-jar", "/backend/app.jar" ]
