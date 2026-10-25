import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class TelemetryPipeline {
    private BlockingQueue<String> messageQueue = new ArrayBlockingQueue<>(5);

    public void produce(String message) throws InterruptedException {
        messageQueue.put(message); // Blocks if queue is full
        System.out.println("[PRODUCER] Dispatched: " + message);
    }

    public String consume() throws InterruptedException {
        String message = messageQueue.take(); // Blocks if queue is empty
        System.out.println("[CONSUMER] Processed: " + message);
        return message;
    }
}// JavaDoc update
