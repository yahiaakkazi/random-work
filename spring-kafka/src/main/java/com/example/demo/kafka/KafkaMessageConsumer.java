import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;

@Component
public class KafkaMessageConsumer {

    private final SimpMessagingTemplate messagingTemplate;

    @Autowired
    public KafkaMessageConsumer(SimpMessagingTemplate messagingTemplate) {
        this.messagingTemplate = messagingTemplate;
    }

    @KafkaListener(topics = "test-topic")
    public void consumeMessage(ConsumerRecord<String, String> record) {
        String key = record.key();
        String value = record.value();
        String topic = record.topic();
        int partition = record.partition();
        long offset = record.offset();

        System.out.println("Received message:");
        System.out.println("Key: " + key);
        System.out.println("Value: " + value);
        System.out.println("Topic: " + topic);
        System.out.println("Partition: " + partition);
        System.out.println("Offset: " + offset);

        String destination = "/topic/messages";
        String message = "Received message:\nKey: " + key + "\nValue: " + value + "\nTopic: " + topic +
                "\nPartition: " + partition + "\nOffset: " + offset;

        messagingTemplate.convertAndSend(destination, message);
    }
}
