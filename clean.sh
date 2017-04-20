#!/bin/bash

docker stop transactionrestapi_web_server_1
docker stop mongo

docker rm transactionrestapi_web_server_1
docker rm mongo

docker rmi transactionrestapi_web_server:latest
docker rmi java:8
docker rmi mongo:3.0