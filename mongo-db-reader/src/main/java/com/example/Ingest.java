import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.apache.kafka.clients.consumer.*;
import org.apache.kafka.common.serialization.StringDeserializer;
import java.util.Collections;
import java.util.Properties;


public class Ingest {
    public static void main(String[] args) {
    	KConsumer kConsumer = new KConsumer();
    	KafkaConsumer<String, String> consumer = kConsumer.instantiateConsumer();
	try {
            while (true) {
                ConsumerRecords<String, String> records = consumer.poll(10);
                for (ConsumerRecord<String, String> record : records) {
                    MongoDBIngester.ingestRecord(record);
                    System.out.println("Document ingested successfully!");
                }
            }
        } finally {
            consumer.close();
        }
    }
}
