# kafka-consumer-producer-apps

## Getting started

This repo contains two java apps, the first one produces messages into a kafka topic, the second one consumes the topic and displays the messages in stdout.

## Setting up kafka

The process is simple using docker-compose, just run the following command.

```
docker-compose up -d
```

Once the two containers are up and running, you can run the java apps.
You can initially check whether the two containers are indeed running through:

```
docker ps
````

## Running the apps

In order to run each app, all you need to do is run the following commands in each app direcotry, in which pom.xml is located:

```
mvn exec:java
```


If one wants to edit the configuration of the app, one should compile it before running it to build the new compiled runnable app.

```
mvn compile
```

