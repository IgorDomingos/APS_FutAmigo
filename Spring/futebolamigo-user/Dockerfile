# Use a base image with JDK 17
FROM openjdk:17-jdk-alpine

# Create a directory in the Docker image
WORKDIR /user

# Copy the JAR file from your host to the Docker image
COPY target/futebolamigo-user-*.jar /app/futebolamigo-user.jar

# Set the default command to run your application
CMD ["java", "-jar", "/user/futebolamigo-user.jar"]