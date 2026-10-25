public class AsyncWebEngineApp {
    public static void main(String[] args) {
        System.out.println("=== Async Web Engine & Telemetry App ===");
        System.out.println("Default JVM Main Thread Name: " + Thread.currentThread().getName());

        TelemetryThread telemetryWorker = new TelemetryThread("Telemetry-Worker");
        LogProcessorTask logTask = new LogProcessorTask();
        Thread logWorker = new Thread(logTask, "Log-Worker");

        // Start threads concurrently
        telemetryWorker.start();
        logWorker.start();

        // Synchronize threads using join barrier
        try {
            telemetryWorker.join();
            logWorker.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("[main] Both worker threads completed cleanly. Main thread terminating.");
    }
}// JavaDoc update
