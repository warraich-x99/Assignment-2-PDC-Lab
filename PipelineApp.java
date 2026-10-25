public class PipelineApp {
    public static void main(String[] args) {
        System.out.println("=== Concurrent Producer-Consumer Telemetry Pipeline ===");
        TelemetryPipeline pipeline = new TelemetryPipeline();

        // Producer Thread
        Thread producer = new Thread(() -> {
            try {
                for (int i = 1; i <= 3; i++) {
                    pipeline.produce("Telemetry-Event-0" + i);
                    Thread.sleep(500);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }, "Producer-Thread");

        // Consumer Thread
        Thread consumer = new Thread(() -> {
            try {
                for (int i = 1; i <= 3; i++) {
                    pipeline.consume();
                    Thread.sleep(800);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }, "Consumer-Thread");

        producer.start();
        consumer.start();

        try {
            producer.join();
            consumer.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("[PIPELINE COMPLETE] All telemetry packets successfully processed.");
    }
}// JavaDoc update
