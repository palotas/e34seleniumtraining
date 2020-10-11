#!/bin/bash

echo "stop all containers..."
docker kill $(docker ps -q)

echo "remove all containers..."
docker rm $(docker ps -a -q)

echo "remove all docker images..."
docker rmi $(docker images -q)

echo "remove all docker volumes..."
docker volume ls -qf dangling=true | xargs -r docker volume rm