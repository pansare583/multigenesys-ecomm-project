# Build stage
FROM maven:3.9-eclipse-temurin-17-jammy AS build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# Run stage
FROM eclipse-temurin:17-jre-jammy
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar

# Render uses dynamic PORT, Spring is configured to listen on it via application.properties
EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]
