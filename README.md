# transaction-rest-api

Requirements
------------
- Docker
- Docker Compose
- Maven


How to run
----------

```./run.sh``` -- on Linux

How to clean (running containers and images)
--------------------------------------------

```./clean.sh``` -- on Linux

Implementation details
----------------------

The implementation was done using Java and Spring.
The application follows the basic Spring architecture:
- Model Layer -> an object from the database
- Repository Layer -> queries to the database
- Controller Layer -> exposes required API

The basic principle is that an object in the database, namely a transaction,
is represented in the Model Layer as a Transaction.
The Repository Layer offers the possibility to query the database.
In the Controller Layer, the required API is exposed.

** For this particular case, the Service Layer was skipped.

Available API
-------------

- POST to http://127.0.0.1:5000/transactions/

Adds a new transaction into the database given a JSON payload of the form:

{

	"sender" : sender_id (integer)

	"receiver" : receiver_id (integer)

	"timestamp" : ts (integer) -- epoch time

	"sum" : x (integer)

}

- DELETE to http://127.0.0.1:5000/transactions/deleteAll

Clears the database.

- GET to http://127.0.0.1:5000/transactions/

Lists all the transactions in the database.

- GET to http://127.0.0.1:5000/transactions/?user=XXXX&day=YYYY&threshold=ZZZZ

Lists all transactions in which the user was involved in the given day, in
transactions larger than threshold.

user 		- integer

day 		- integer (date value in epoch time)

threshold 	- integer


- GET to http://127.0.0.1:5000/balance/?user=XXXX&since=YYYY&until=ZZZZ

List the balance of a user, given a timeframe.

user 		- integer

since 		- integer (date value in epoch time)

until 		- integer (date value in epoch time)


The database has an index on the timestamp field. Further documentation is needed
to improve the queries for large data (compound indexes and background indexing).

Docker
------
The application is deployed into two docker containers:
- mongo -- contains the mongoDB
- transactionrestapi_web_server -- contains the application JAR

The application JAR uses the port ``27017`` exposed by the mongoDB container. It 
exposes the api at ``http://localhost:5000``.


TODO
----

Improve indexes. 
Add tests.
