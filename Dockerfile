# Build stage
FROM maven:3.9.6-eclipse-temurin-17 AS build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# Run stage
FROM eclipse-temurin:17-jre-jammy
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar

# Render uses dynamic PORT, Spring is configured to listen on it via application.properties
EXPOSE 8080

# Added -Xmx400m to prevent OutOfMemory errors on Render's Free Tier (512MB RAM)
ENTRYPOINT ["java", "-Xmx400m", "-jar", "app.jar"]
