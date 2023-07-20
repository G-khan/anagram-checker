# Use the official OpenJDK image as the base image
FROM adoptopenjdk:11-jre-hotspot AS build

# Set the working directory inside the container
WORKDIR /app

# Copy the source code to the working directory
COPY . .

# Build the application
RUN ./gradlew build

# Create a new Docker image with only the necessary artifacts
FROM adoptopenjdk:11-jre-hotspot

# Set the working directory inside the container
WORKDIR /app

# Copy the compiled application from the build stage to the working directory
COPY --from=build /app/build/libs/anagramchecker-1.0-SNAPSHOT.jar ./AnagramChecker.jar

# Command to run the application
CMD ["java", "-jar", "AnagramChecker.jar"]
