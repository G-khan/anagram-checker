# Use the official Kotlin image as the base image
FROM kotlindocker/kotlin:1.5.21-jdk11-slim AS build

# Set the working directory inside the container
WORKDIR /app

# Copy the source code to the working directory
COPY src/ ./src/
COPY gradle/ ./gradle/
COPY build.gradle ./build.gradle
COPY gradlew ./gradlew

# Build the application
RUN ./gradlew build

# Create a new Docker image with only the necessary artifacts
FROM openjdk:11-jre-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the compiled application from the build stage to the working directory
COPY --from=build /app/build/libs/AnagramChecker.jar ./AnagramChecker.jar

# Expose the port on which the application will listen (if applicable)
# EXPOSE <port>

# Command to run the application
CMD ["java", "-jar", "AnagramChecker.jar"]