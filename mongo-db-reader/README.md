## kafka-mongodb-ingester

This java app is used to create a service capabale of reading kafka topics, & ingesting consumed data into a mongodb collection.
We use a kafka consumer object initialized from a custom class to subscribe to kafka topics, and a MongoIngesterDB object to first connect to the database and then ingest the record to the specified mongodb collection.

Running the app

First of all, one must install a mongodb instance. We use docker since it is easy to setup:

$ docker pull mongodb/mongodb-community-server
$ docker run --name mongo -d -p 27017:27017 mongodb/mongodb-community-server:latest

This will build a mongodb container (beware of port specification and how you map the host and the container ports), you get inside of the container and create a mongodb database:

$ docker exec -it mongo mongosh
>show dbs
>use test-database
>exit

Now you can compile & run the java app using: 

$ mvn compile
$ mvn exec:java

putphotohere:

We can test our solution by producing a test message in a kafka topic, using the kafka-producer app: https://gitlab.tech.orange/yahia.akkazi/

Once the message is published, it is consumed by the java app and ingested to the database:

putphotohere:

We can also make sure it worked by querying the mongodb instance:

$ docker exec -it mongo mongosh
>show dbs
>use test-database
>db.testCollection.findAll()

putphotohere:
