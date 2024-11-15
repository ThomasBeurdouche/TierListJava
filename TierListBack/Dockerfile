# Stage 1: Build the application using Maven
FROM maven:3.9.2-eclipse-temurin-17 AS build

WORKDIR /app
COPY .. /app
RUN mvn clean package -DskipTests

# Use PostgreSQL as the base image for the database
FROM postgres:13

ENV POSTGRES_DB=local_database
ENV POSTGRES_USER=root
ENV POSTGRES_PASSWORD=toor

COPY initdb /docker-entrypoint-initdb.d/

# Stage 2: Run the Spring Boot application in a separate container
FROM openjdk:17-jdk-slim

WORKDIR /app
COPY --from=build /app/target/back-skeleton-0.0.1-SNAPSHOT.jar /app/back-skeleton.jar

ENTRYPOINT ["java", "-jar", "/app/back-skeleton.jar"]


# Stage 3: Build and serve the Angular application
#FROM node:18 AS frontend

#WORKDIR /app
#COPY ../TierListFront /app
#RUN npm install
#RUN npm run build

#CMD ["npm", "start"]