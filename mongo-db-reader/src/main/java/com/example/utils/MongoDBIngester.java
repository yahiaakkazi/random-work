import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.apache.kafka.clients.consumer.*;

public class MongoDBIngester {
    public static void ingestRecord(ConsumerRecord<String, String> record) {
    
        String connectionString = "localhost:27017";
        String databaseName = "test-database";
        String collectionName = "testCollection";

	try (MongoClient mongoClient = new MongoClient(connectionString)) {
            MongoDatabase database = mongoClient.getDatabase(databaseName);
            MongoCollection<Document> collection = database.getCollection(collectionName);
            Document document = Document.parse(record.value());
            collection.insertOne(document);
        } catch (Exception e) {
            System.err.println("An error occurred: " + e);
        }
     }
}
