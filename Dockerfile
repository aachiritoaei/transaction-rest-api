# Use Ububtu 16.04 as our base O/S
FROM java:8

# Set our working directory
WORKDIR /

# Copy the application from its folder to our image
# Assumes docker build is run from /myapp/src
ADD /target/transaction-rest-api-1.0-SNAPSHOT.jar /transaction-rest-api-1.0-SNAPSHOT.jar

# Run the app when the container is executed.
CMD ["java", "-jar",  "transaction-rest-api-1.0-SNAPSHOT.jar"]