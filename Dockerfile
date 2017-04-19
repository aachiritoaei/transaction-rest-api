# Use java 8 container
FROM java:8

# Set our working directory
WORKDIR /

# Copy the application from its folder to our image
ADD /target/transaction-rest-api-1.0-SNAPSHOT.jar /transaction-rest-api-1.0-SNAPSHOT.jar

# Run the app when the container is executed.
CMD ["java", "-jar",  "transaction-rest-api-1.0-SNAPSHOT.jar"]