# transaction-rest-api

How to create and run JAR
-------------------------

Execute the following command from the directory where pom.xml is:

```mvn package & java -jar <jar_name>```

How to create and run docker images
-----------------------------------

Start mongo container:
```docker run -d -p 27017:27017 --name my_mongodb1 mongo```

Create image:
```docker build -t transaction-api .```

Run container:

```docker run -p 5000:5000 --name my-transaction-api -d transaction-api```