#!/bin/bash

container_name="661485c2e11f"
topic="test-topic"

random_message=$(cat /dev/urandom | tr -dc 'a-zA-Z0-9' | fold -w 32 | head -n 1)


sudo docker exec -i $container_name bash -c "echo $random_message | kafka-console-producer --topic $topic --bootstrap-server localhost:9092"
