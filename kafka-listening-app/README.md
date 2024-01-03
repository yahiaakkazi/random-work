# kafka-dynamic-topic-reader

This java app is used to create a service to consume content from kafka topics and display synchronously in a web page.

Kafka content is consumed using KafkaListener, a bean provided by Springboot, the content is then sent to a websocket, this websocket is getting connected to a javascript webpage which displays
provided messages.

# Running the app

First of all, one must compile & creat a jar package for the app using:

```
mvn compile && mvn clean package
```

Finally the app is run using the jar provided inside the /target directory

```
java -jar """.jar
```
