# Use an official Maven image to build the project
FROM maven:3.8.7-eclipse-temurin-17 AS build

# Set the working directory
WORKDIR /app

# Copy the pom.xml and any other files needed for dependency resolution
COPY pom.xml .

# Download dependencies
RUN mvn dependency:go-offline -B

# Copy the entire project into the working directory
COPY . .

# Build the application
RUN mvn clean package -DskipTests

# Use an OpenJDK runtime as the base image
FROM eclipse-temurin:17-jdk-jammy

# Set the working directory
WORKDIR /app

# Copy the built JAR file from the previous stage
COPY --from=build /app/target/*.jar app.jar

# Expose port 8080 for the application
EXPOSE 8080

# Run the JAR file
ENTRYPOINT ["java", "-jar", "app.jar"]
