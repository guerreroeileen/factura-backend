FROM maven:3.9.6-eclipse-temurin-22-jammy AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

FROM openjdk:22-jdk-slim
WORKDIR /app
COPY --from=build /app/target/factura_backend-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]
